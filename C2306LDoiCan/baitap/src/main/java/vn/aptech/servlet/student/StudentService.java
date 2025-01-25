package vn.aptech.servlet.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final EntityManagerFactory emf;

    public StudentService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public long getTotalStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(s) FROM STUDENTS s");
            return ((Long) query.getSingleResult());
        } catch (Exception e) {
            return 0L;
        } finally {
            em.close();
        }
    }

    public List<Student> getAllStudents(int page, int size) {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("select s from STUDENTS s", Student.class);
            query.setFirstResult((page - 1) * size);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error get all students: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            em.close();
        }

    }

    public boolean existByEmail(String email) {
        EntityManager em = this.emf.createEntityManager();
        try {
            Query query = em.createQuery("select s from STUDENTS s where s.email = :email", Student.class);
            query.setParameter("email", email);
            return query.getSingleResult() != null;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
        }
    }

    public void addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error adding student: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void updateStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error update student: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            em.remove(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error delete student: " + e.getMessage());
        }
    }

    public Student getStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Student.class, id);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
