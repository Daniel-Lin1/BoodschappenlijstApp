package models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ingredient extends Necessity {
    @Column(name = "volume")
    private int volume;

    @Column(name = "image")
    private String image;

    @Column(name = "measurement")
    private Measurement measurement;

    public Ingredient() {

    }

    public Ingredient(String name, int volume, String image, Measurement measurement) {
        super(name);
        this.volume = volume;
        this.image = image;
        this.measurement = measurement;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }
}
