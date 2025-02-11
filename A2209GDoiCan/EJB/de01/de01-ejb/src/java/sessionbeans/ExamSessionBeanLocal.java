/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package sessionbeans;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangnd
 */
@Local
public interface ExamSessionBeanLocal {
    List<Object[]> findAllSchedules();
    void cancelSchedule(int scheduleId);
}
