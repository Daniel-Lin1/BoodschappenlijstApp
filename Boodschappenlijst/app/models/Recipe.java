package models;

import java.util.List;

public class Recipe {
    private String name;
    private String procedure;
    private boolean secret;

    private List<Necessity> necessities;

    public Recipe() {

    }
}
