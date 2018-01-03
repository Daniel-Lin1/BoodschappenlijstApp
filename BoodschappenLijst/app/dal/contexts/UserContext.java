package dal.contexts;

import dal.interfaces.UserContextJPA;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserContext implements UserContextJPA {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public boolean register(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return false;
    }

//    public void deleteAccount(User user){
//        entityManager.getTransaction().begin();
//        entityManager.remove(user);
//        entityManager.getTransaction().commit();
//        entityManagerFactory.close();
//    }

    @Override
    public java.util.List<User> getAllUsers(){
        return entityManager.createNamedQuery("User.getAll", User.class).getResultList();
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        User user = entityManager.createNamedQuery("User.login",User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        if(user != null){
            return true;
        }
        return false;
    }
}
