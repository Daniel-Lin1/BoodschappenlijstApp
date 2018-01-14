package dal.interfaces;

import models.Ingredient;

public interface IngredientContextJPA {
    boolean addIngredient(Ingredient ingredient);
    boolean deleteIngredient(long _id);
    Ingredient getIngredient(long _id);
    boolean updateIngredient(Ingredient ingredient);
}
