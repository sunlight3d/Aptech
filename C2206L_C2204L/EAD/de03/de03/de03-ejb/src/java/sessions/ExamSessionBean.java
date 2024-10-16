/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package sessions;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.Topic;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import models.Exam;

/**
 *
 * @author hoangnd
 */
@Stateless
public class ExamSessionBean implements ExamSessionBeanLocal {
    @Resource(lookup = "java:/jms/exam_topic")
    private Topic topic;

    @PersistenceContext
    private EntityManager entityManager;
    
    @Resource(mappedName = "java:/JmsXA")
    private JMSContext context;

    @Override
    public List<Exam> findAllExams() {
        TypedQuery<Exam> query = entityManager.createNamedQuery("Exams.findAll", Exam.class);
        return query.getResultList();
    }
    

    

    @Override
    public void saveExam(String name, int duration, String description) {
        JsonObject examJson = Json.createObjectBuilder()
                .add("name", name)
                .add("duration", duration)
                .add("description", description)
                .build();
        context.createProducer().send(topic, examJson.toString());
    }
}
