package models;

public class Ingredient extends Necessity {
    private int volume;
    private String image;
    private Measurement measurement;
    
    public Ingredient(String name, int volume, String image, Measurement measurement) {
        super(name);
        this.volume = volume;
        this.image = image;
        this.measurement = measurement;
    }
}
