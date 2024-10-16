/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package providers;

import javax.persistence.*;



public class EntityManagerFactoryProvider {
    private static final String PERSISTENCE_UNIT_NAME = "de05PU"; // Name of your persistence unit defined in persistence.xml
    
    private static EntityManagerFactory entityManagerFactory;
    
    // Method to create the EntityManagerFactory
    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }
    
    // Method to close the EntityManagerFactory
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}

