package dal.repositories;

import models.Recipe;
import models.User;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class JPARecipeRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPARecipeRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    public CompletionStage<Recipe> add(Recipe recipe) {
        return supplyAsync(() -> wrap(em -> insert(em, recipe)), executionContext);
    }

    private Recipe insert(EntityManager em, Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    // wrapper function for returning something
    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public List<Recipe> list() {
        return jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            return em.createQuery("select r from Recipe r", Recipe.class).getResultList();
        });
    }
}
