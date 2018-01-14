package dal.interfaces;

import models.Kitchenware;

public interface KitchenwareContextJPA {
    boolean addKitchenware(Kitchenware kitchenware);
    boolean deleteKitchenware (long _id);
    Kitchenware getKitchenware(long _id);
    boolean updateKitchenware (Kitchenware kitchenware);
}
