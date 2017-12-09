package controllers;

import models.User;
import play.*;
import play.db.jpa.JPAApi;
import play.mvc.*;

import views.html.*;
import views.html.shared.index;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application extends Controller {
  //  private JPAApi jpaApi;

   /* @Inject
    public Application(JPAApi api) {
        this.jpaApi = api;
    } */

    public Result index() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
       // EntityManager em = jpaApi.em();

        User user = new User("harry", "harry@live.nl", "hallo123");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        return ok(index.render());
    }

}
