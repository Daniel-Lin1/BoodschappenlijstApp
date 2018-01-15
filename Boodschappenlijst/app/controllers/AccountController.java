package controllers;

import dal.repositories.JPAUserRepository;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import views.html.account.login;
import views.html.shared.index;

import javax.inject.Inject;

import static play.mvc.Controller.ctx;
import static play.mvc.Controller.session;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class AccountController {
    private Form<User> form;
    private FormFactory formFactory;
    private JPAUserRepository userRepo;

    @Inject
    public AccountController(FormFactory formFactory, JPAUserRepository userRepo) {
        this.formFactory = formFactory;
        this.form = formFactory.form(User.class);
        this.userRepo = userRepo;
    }

    public Result login(){
        return ok(login.render(form, userRepo.getUserByUsername(session("user"))));
    }

    public Result logout() {
        session().clear();
        return ok(index.render(null));
    }

    public Result authenticate() {
        Form<User> filledForm = form.bindFromRequest();
        User user = filledForm.get();

        if(filledForm.hasErrors()) {
            return badRequest(login.render(form, userRepo.getUserByUsername(session("user"))));
        }

        boolean result = userRepo.login(user.getUsername(), user.getPassword());

        if(result) {
            System.out.println("Login successful");
            ctx().session().put("user", user.getUsername());
        } else {
            System.out.println("Invalid credentials.");
        }

        return ok(index.render(null));
    }

}
