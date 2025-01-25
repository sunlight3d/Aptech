package vn.aptech.servlet.service;

import vn.aptech.servlet.database.entity.Account;
import vn.aptech.servlet.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private static AccountService instance;

    private AccountService() {
    }

    public static AccountService getInstance() {
        if (instance == null) {
            instance = new AccountService();
        }
        return instance;
    }

    public void createAccount(Account account) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }


    }

    public List<Account> getAccounts() {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        try {
            Query query = em.createQuery("select a from Account a", Account.class);
            return (List<Account>) query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }
}
