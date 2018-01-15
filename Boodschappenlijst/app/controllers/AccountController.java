package controllers;

import models.User;
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

    @Inject
    public AccountController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.form = formFactory.form(User.class);
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

}
