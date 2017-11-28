package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import views.html.shared.index;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

}
