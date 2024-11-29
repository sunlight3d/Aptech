package com.example.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import javax.ejb.ActivationConfigProperty;
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/exam_topic")
})

@Stateless
public class ExamSessionBean implements ExamSessionBeanLocal, MessageListener  {

    @PersistenceContext(unitName = "project01-ejbPU")
    private EntityManager em;

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/exam_topic")
    private Topic examTopic;

    @Override
    public List<Exam> getAllExams() {
        return em.createQuery("SELECT e FROM Exam e", Exam.class).getResultList();
    }

    @Override
    public Exam findExamById(int id) {
        return em.find(Exam.class, id);
    }

    @Override
    public void addExam(Exam exam) {
        em.persist(exam);
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            try {
                MapMessage mapMessage = (MapMessage) message;

                // Retrieve exam details from the message
                String name = mapMessage.getString("name");
                int duration = mapMessage.getInt("duration");
                String description = mapMessage.getString("description");

                // Create new Exam entity
                Exam exam = new Exam();
                exam.setName(name);
                exam.setDuration(duration);
                exam.setDescription(description);
                exam.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                exam.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

                // Persist to database
                em.persist(exam);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void updateExam(Exam exam) {
        Exam existingExam = findExamById(exam.getId());
        if (existingExam != null) {
            existingExam.setName(exam.getName());
            existingExam.setDuration(exam.getDuration());
            existingExam.setDescription(exam.getDescription());
            em.merge(existingExam);
        }
    }

    @Override
    public void deleteExam(int id) {
        Exam exam = findExamById(id);
        if (exam != null) {
            em.remove(exam);
        }
    }

    @Override
    public void saveExam(String name, int duration, String description) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(examTopic);

            MapMessage message = session.createMapMessage();
            message.setString("name", name);
            message.setInt("duration", duration);
            message.setString("description", description);

            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
