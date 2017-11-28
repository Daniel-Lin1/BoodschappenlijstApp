package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

public class AccountController {

    public Result login(){
        return ok("Succesvol Ingeschreven");
    }

}
