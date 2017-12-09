package models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Kitchenware extends Necessity {

    public Kitchenware() {

    }

    public Kitchenware(String name) {
        super(name);
    }
}
