package dal.contexts;

import dal.interfaces.IngredientContextJPA;
import models.Ingredient;

public class IngredientContext implements IngredientContextJPA {

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return false;
    }

    @Override
    public boolean deleteIngredient(long _id) {
        return false;
    }

    @Override
    public Ingredient getIngredient(long _id) {
        return null;
    }

    @Override
    public boolean updateIngredient(Ingredient ingredient) {
        return false;
    }
}
