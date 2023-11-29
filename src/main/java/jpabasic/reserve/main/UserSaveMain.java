package jpabasic.reserve.main;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class UserSaveMain {
    private static Logger logger = LoggerFactory.getLogger(UserSaveMain.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.creaEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User("userkor@user.com", "한글유저", LocalDateTime.now());
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        EMF.close();
    }
}
