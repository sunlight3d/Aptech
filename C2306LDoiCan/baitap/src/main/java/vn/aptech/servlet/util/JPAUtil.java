package vn.aptech.servlet.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
    private static JPAUtil instance;

    private JPAUtil() {
    }

    public static JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("StudentPU").createEntityManager();
    }
}
