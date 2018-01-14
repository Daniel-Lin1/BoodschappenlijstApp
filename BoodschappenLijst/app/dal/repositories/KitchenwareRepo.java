package dal.repositories;

import dal.interfaces.KitchenwareContextJPA;

public class KitchenwareRepo {
    private KitchenwareContextJPA kitchenwareContext;

    public KitchenwareRepo(KitchenwareContextJPA kitchenwareContext){
        this.kitchenwareContext = kitchenwareContext;
    }
}
