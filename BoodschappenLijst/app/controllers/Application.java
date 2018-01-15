package controllers;

import dal.repositories.DatabaseExecutionContext;
import dal.repositories.JPARecipeRepository;
import dal.repositories.JPAUserRepository;
import models.*;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
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
    private JPAUserRepository userRepo;
    private JPARecipeRepository recipeRepo;

    @Inject
    public Application(JPAUserRepository userRepo, JPARecipeRepository recipeRepo) {
        this.userRepo = userRepo;
        this.recipeRepo = recipeRepo;
    }

    @Transactional
    public Result index() {
        User user = new User("harry", "harry@live.nl", "hallo123");
        Recipe recipe = new Recipe("Rijst", "De perfecte rijst voor bodybuilders!", false);
        Ingredient ingredient = new Ingredient("Water", 20, "water.pjg", Measurement.ml);
        Kitchenware kitchenware = new Kitchenware("Vork");

        userRepo.add(user);
        recipeRepo.add(recipe);

        // TODO:
        // De recipe klasse persisten lukt niet, zou je hier naar kunnen kijken,
        // waarom hij een error geeft?

        return ok(index.render());
    }

    public Result getResults() {
        List<User> users = userRepo.list();
        List<Recipe> recipes = recipeRepo.list();
        return ok(getResults.render(users, recipes));
    }

    /*public List<User> findAll() {
        return entityManager.createNamedQuery("User.getAll", User.class)
                .getResultList();
    } */

}
