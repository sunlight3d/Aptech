/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Calculation;

/**
 *
 * @author nguye
 */
@Stateless
public class CalculatorBean implements CalculatorBeanLocal {
    @PersistenceContext(unitName = "CalculationApp-ejbPU")
    private EntityManager em;

    @Override
    public double addNumbers(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public void saveCalculation(double num1, double num2, double result) {
        Calculation calculation = new Calculation(num1, num2, result);
        em.persist(calculation);//save to db
    }

    @Override
    public List<Calculation> getAllCalculations() {
       return em.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
    }

  
}
