package dal.contexts;

import dal.interfaces.KitchenwareContextJPA;
import models.Kitchenware;

public class KitchentwareContext implements KitchenwareContextJPA {
    @Override
    public boolean addKitchenware(Kitchenware kitchenware) {
        return false;
    }

    @Override
    public boolean deleteKitchenware(long _id) {
        return false;
    }

    @Override
    public Kitchenware getKitchenware(long _id) {
        return null;
    }

    @Override
    public boolean updateKitchenware(Kitchenware kitchenware) {
        return false;
    }
}
