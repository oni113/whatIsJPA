package jpabasic.reserve.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class UserUpdateMain {
    private static Logger logger = LoggerFactory.getLogger(UserUpdateMain.class);
    
    public static void main(String[] args) {
        EMF.init();
        EntityManager entityManager = EMF.creaEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = entityManager.find(User.class, "user@user.com");
            if (user == null) {
                logger.info("User 없음");
            } else {
                String newName = "이름" + (System.currentTimeMillis() % 100);
                user.changeName(newName);
                user.updateModifyDate();
            }
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
