package dal.interfaces;

import models.Recipe;
import java.util.*;

public interface RecipeContextJPA {
    boolean addRecipe();
    boolean deleteRecipe();
    List<Recipe>getAllRecipes();
    List<Recipe>getAllMyRecipes();
    boolean updateRecipe();
}
