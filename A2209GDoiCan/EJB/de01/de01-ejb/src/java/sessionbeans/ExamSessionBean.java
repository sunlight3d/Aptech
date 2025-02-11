/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package sessionbeans;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.*;
import javax.jms.Topic;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hoangnd
 */
@Stateless
public class ExamSessionBean implements ExamSessionBeanLocal {

        @PersistenceContext(unitName = "ExamPU")
    private EntityManager em;

    @Resource(mappedName = "java:/jms/topic/schedule_topic")
    private Topic scheduleTopic;

    @Resource
    private ConnectionFactory connectionFactory;

    @Override
    public List<Object[]> findAllSchedules() {
    String jpql = "SELECT e, ea, s " +
                  "FROM Exam e " +
                  "JOIN ExamAttendance ea ON e.id = ea.exam.id " +
                  "JOIN Schedule s ON ea.scheduler.id = s.id";

        Query query = em.createNativeQuery(jpql);
        return query.getResultList();
    }
    @Override
    public void cancelSchedule(int scheduleId) {
        try (Connection connection = connectionFactory.createConnection();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {

            MessageProducer producer = session.createProducer(scheduleTopic);
            TextMessage message = session.createTextMessage(String.valueOf(scheduleId));
            producer.send(message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
    
