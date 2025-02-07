/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package sessions;

import java.util.List;
import javax.ejb.Local;
import models.*;

@Local
public interface CalculatorBeanLocal {
    double addNumbers(double num1, double num2);
    void saveCalculation(double num1, double num2, double result);
    List<Calculation> getAllCalculations();

}
