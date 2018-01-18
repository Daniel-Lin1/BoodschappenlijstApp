package controllers;
import dal.repositories.DatabaseExecutionContext;
import dal.repositories.JPARecipeRepository;
import dal.repositories.JPAUserRepository;
import models.Encryptor;
import models.Recipe;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.shared.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.inject.Inject;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RecipeController extends Controller{

    private Form<Recipe> form;
    private DynamicForm form2;
    private FormFactory formFactory;

    JPARecipeRepository recipeRepo;

    @Inject
    public RecipeController(FormFactory formFactory, JPARecipeRepository recipeRepo){
        this.formFactory = formFactory;
        form = this.formFactory.form(Recipe.class);
        form2 = formFactory.form();
        this.recipeRepo = recipeRepo;
    }

    public Result addRecipe(){
        return ok(newRecipe.render(form, null));
    }

    public Result submit() throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        form2 = formFactory.form().bindFromRequest();
        String name = form2.get("name");
        String procedure = form2.get("procedure");

        name = Encryptor.Encrypt(name, "XMzDdG4D03CKm2IxIWQw7g==");
        procedure = Encryptor.Encrypt(procedure, "XMzDdG4D03CKm2IxIWQw7g==");

        Recipe recipe = new Recipe(name, procedure);
        recipeRepo.add(recipe);
        return redirect(routes.Application.index());
    }
}
