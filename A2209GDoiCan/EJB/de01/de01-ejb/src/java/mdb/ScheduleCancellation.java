/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.MessageListener;
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
@JMSDestinationDefinition(name = "java:/jms/topic/schedule_topic", interfaceName = "javax.jms.Topic", resourceAdapter = "jmsra", destinationName = "schedule_topic")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "java:/jms/topic/schedule_topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/schedule_topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "java:/jms/topic/schedule_topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class ScheduleCancellation implements MessageListener {
    
    @PersistenceContext(unitName = "ExamPU")
    private EntityManager em;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                int scheduleId = Integer.parseInt(((TextMessage) message).getText());
                List<String> studentNames = getStudentsBySchedule(scheduleId);
                
                System.out.println("Hi Students, the exam schedule has just been canceled.");
                System.out.println("Please check your name below to confirm that you are not taking the exam due to the cancellation:");
                for (String student : studentNames) {
                    System.out.println(student);
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    private List<String> getStudentsBySchedule(int scheduleId) {
        String jpql = "SELECT s.full_name FROM students s " +
                      "JOIN exam_attendance ea ON s.roll_no = ea.student_roll_no " +
                      "WHERE ea.scheduler_id = :scheduleId";
        return em.createNativeQuery(jpql)
                 .setParameter("scheduleId", scheduleId)
                 .getResultList();
    }    
}
