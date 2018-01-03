package dal.contexts;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountController {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void registerUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }

    public void deleteAccount(User user){
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }

    public java.util.List<User> getAllUsers(){
        return entityManager.createNamedQuery("User.getAll", User.class).getResultList();
    }

    public void login(){

    }
}
