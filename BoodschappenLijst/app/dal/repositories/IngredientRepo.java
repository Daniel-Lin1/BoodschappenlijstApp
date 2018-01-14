package dal.repositories;

import dal.interfaces.IngredientContextJPA;

public class IngredientRepo {

    private IngredientContextJPA ingredientContext;

    public IngredientRepo(IngredientContextJPA ingredientContext){
        this.ingredientContext = ingredientContext;
    }
}
