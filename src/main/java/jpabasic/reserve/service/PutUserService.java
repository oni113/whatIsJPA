package jpabasic.reserve.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class PutUserService {
    
    public void changeUserName(String email, String newName) {
        EntityManager em = EMF.creaEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            User user = em.find(User.class, email);
            if (user == null) {
                throw new NoUserException();
            }
            user.changeName(newName);
            user.updateModifyDate();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
