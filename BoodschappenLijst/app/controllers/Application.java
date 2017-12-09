package controllers;

import models.*;
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

       // User user = new User("harry", "harry@live.nl", "hallo123");
        Recipe recipe = new Recipe("Rijst", "De perfecte rijst voor bodybuilders!", false);
      //  Ingredient ingredient = new Ingredient("Water", 20, "water.pjg", Measurement.ml);
       // Kitchenware kitchenware = new Kitchenware("Vork");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(recipe);
        // TODO:
        // De recipe klasse persisten lukt niet, zou je hier naar kunnen kijken,
        // waarom hij een error geeft?
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        return ok(index.render());
    }

}
