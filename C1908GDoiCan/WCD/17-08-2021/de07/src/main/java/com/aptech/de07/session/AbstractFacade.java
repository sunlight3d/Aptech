/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractFacade<T> {
    public static final String unitName = "com.aptech_de07_war_1.0-SNAPSHOTPU";
    //abstract method    
    public EntityManager getEntityManager() {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
            return entityManagerFactory.createEntityManager();        
        }catch(Exception e) {
            System.err.println("Cannot connect to DB:"+e.getMessage());
            return null;
        }
    }
    private Class<T> entityClass;
    public AbstractFacade (Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
}
