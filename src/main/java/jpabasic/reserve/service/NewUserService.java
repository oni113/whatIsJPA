package jpabasic.reserve.service;

import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class NewUserService {
    

    public void createUser(String email, String name) {
        EMF.init();
        EntityManager em = EMF.creaEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User newUser = new User(email, name, LocalDateTime.now());
            em.persist(newUser);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
