package jpabasic.reserve.service;

import jakarta.persistence.EntityManager;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class GetUserService {
    public User getUser(String email) {
        EntityManager em = EMF.creaEntityManager();
        User user;
        try {
            user = em.find(User.class, email);
        } catch(Exception e) {
            throw new NoUserException();
        } finally {
            em.close();
        }

        return user;
    }
}
