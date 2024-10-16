/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aptech.de07.session;

import javax.persistence.EntityManager;

public abstract class AbstractFacade<T> {
    //abstract method
    protected abstract EntityManager getEntityManager();
    private Class<T> entityClass;
    public AbstractFacade (Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
}
