/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sessions;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;
import models.Exam;

@MessageDriven(mappedName = "java:/jms/exam_topic")
public class ExamMessageDrivenBean implements MessageListener {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void onMessage(Message message) {
        try {
            String name = message.getStringProperty("Name");
            int duration = message.getIntProperty("Duration");
            String description = message.getStringProperty("Description");

            // Create new exam
            Exam exam = new Exam();
            exam.setName(name);
            exam.setDuration(duration);
            exam.setDescription(description);
            exam.setCreatedAt(new Date()); // Set created_at
            exam.setUpdatedAt(new Date()); // Set updated_at

            // Persist the new exam
            entityManager.persist(exam);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
