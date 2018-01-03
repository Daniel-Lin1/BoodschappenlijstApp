package dal.contexts;

import dal.interfaces.RecipeContextJPA;
import models.Recipe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RecipeContext implements RecipeContextJPA {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public boolean addRecipe() {
        return false;
    }

    @Override
    public boolean deleteRecipe() {
        return false;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public List<Recipe> getAllMyRecipes() {
        return null;
    }

    @Override
    public boolean updateRecipe() {
        return false;
    }
}
