/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.example.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
//@Remote
public interface CalculatorBeanLocal {
    int add(int a, int b);
    int subtract(int a, int b);
}
