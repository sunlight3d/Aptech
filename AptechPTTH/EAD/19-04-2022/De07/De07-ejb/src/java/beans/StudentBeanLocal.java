/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Local;

/**
 *
 * @author w11
 */
@Local
public interface StudentBeanLocal {
    public void insert(String name, String email, Integer age);    
}
