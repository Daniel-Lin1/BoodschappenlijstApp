package models;

import dal.contexts.UserContext;
import dal.repositories.UserRepo;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class Secured extends Security.Authenticator {

    private static UserRepo userRepo = new UserRepo(new UserContext());

    @Override
    public String getUsername(Http.Context ctx) {
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return redirect(controllers.routes.AccountController.loginRedirect());
    }

    public static String getUser(Http.Context ctx) {
        return ctx.session().get("email");
    }

    public static boolean isLoggedIn(Http.Context ctx) {
        return (getUser(ctx) != null);
    }

    public static User getUserInfo(Http.Context ctx) {
        return userRepo.getUser(getUser(ctx));
    }
}
