package controllers;

import models.*;
import play.*;
import play.db.jpa.JPAApi;
import play.mvc.*;

import views.html.*;
import views.html.shared.getResults;
import views.html.shared.index;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Application extends Controller {
  //  private JPAApi jpaApi;

   /* @Inject
    public Application(JPAApi api) {
        this.jpaApi = api;
    } */

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Result index() {
       // EntityManager em = jpaApi.em();

        User user = new User("harry", "harry@live.nl", "hallo123");
        Recipe recipe = new Recipe("Rijst", "De perfecte rijst voor bodybuilders!", false);
        Ingredient ingredient = new Ingredient("Water", 20, "water.pjg", Measurement.ml);
        Kitchenware kitchenware = new Kitchenware("Vork");

        entityManager.getTransaction().begin();

        entityManager.persist(user);
        // TODO:
        // De recipe klasse persisten lukt niet, zou je hier naar kunnen kijken,
        // waarom hij een error geeft?
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        return ok(index.render());
    }

    public Result getResults() {
        entityManager.getTransaction().begin();
        List<User> users = findAll();
        return ok(getResults.render(users));
    }

    public List<User> findAll() {
        return entityManager.createNamedQuery("User.getAll", User.class)
                .getResultList();
    }

}
