package controllers;

import dal.DBConnector;
import models.User;
import models.dal.repositories.UserRepo;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import views.html.account.login;

import javax.inject.Inject;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class AccountController {
    private Form<User> form;
    private FormFactory formFactory;
    private DBConnector c = new DBConnector();
    private UserRepo userRepo = new UserRepo();

    @Inject
    public AccountController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.form = formFactory.form(User.class);

        c.connect();

    }

    public Result login(){
        return ok(login.render(form));
    }

    public Result authenticate() {
        Form<User> filledForm = form.bindFromRequest();
        User user = filledForm.get();

        if(filledForm.hasErrors()) {
            return badRequest(login.render(form));
        }
        return ok("Ingelogd bitch");
    }

    private Result login(String username, String password){
        if(userRepo.login(email, password)){
            session().clear();
            if(previousUrl != null) {
                session("previousUrl", previousUrl);
            } else {
                session("previousUrl", "/");
            }
            session("email", email);

            return redirect(session().get("previousUrl"));
        }
        return badRequest(login.render(REGISTER, Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), form2, true));
    }

}
