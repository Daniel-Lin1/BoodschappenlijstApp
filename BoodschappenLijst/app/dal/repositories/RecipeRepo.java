package dal.repositories;

import dal.contexts.RecipeContext;
import dal.interfaces.RecipeContextJPA;

public class RecipeRepo {

    private RecipeContextJPA recipeContext;

    public RecipeRepo(RecipeContextJPA recipeContext){
        this.recipeContext = recipeContext ;
    }
}
