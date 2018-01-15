package dal.repositories;

import models.User;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class JPAUserRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAUserRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    public CompletionStage<User> add(User user) {
        return supplyAsync(() -> wrap(em -> insert(em, user)), executionContext);
    }

    private User insert(EntityManager em, User user) {
        em.persist(user);
        return user;
    }

    public User getUserByUsername(String username) {
        return jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            TypedQuery<User> query = em.createQuery("select u from User u where username = :username", User.class);
            List users = query.setParameter("username", username).getResultList();

            //  User userToLogin = query.setParameter("username", username).getSingleResult();
            User userToLogin = null;

            if (!users.isEmpty()) {
                userToLogin = (User) users.get(0);
                return userToLogin;
            } else {
                return null;
            }
        });
    }

    public boolean login(String username, String password) {
        return jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            return login(em, username, password);
        });
    }

    // wrapper function for returning something
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public List<User> list() {
        return jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            return em.createQuery("select u from User u", User.class).getResultList();
        });
    }

    private boolean login(EntityManager em, String username, String password) {
        TypedQuery<User> query = em.createQuery("select u from User u where username = :username", User.class);
        List users = query.setParameter("username", username).getResultList();
      //  User userToLogin = query.setParameter("username", username).getSingleResult();
        User userToLogin = null;

        if (!users.isEmpty()) {
            userToLogin = (User) users.get(0);
            return password.equals(userToLogin.getPassword());
        } else {
            return false;
        }

       // byte[] passwordToCheck = hash(password, personToLogin.getSalt(), 1000, 256);
    }
}
