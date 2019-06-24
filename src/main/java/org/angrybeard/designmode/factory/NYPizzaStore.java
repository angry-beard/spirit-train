package org.angrybeard.designmode.factory;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class NYPizzaStore extends PizzaStore {

    PizzaStore createPizza(PizzaItem item) {
        if (PizzaItem.CHEESE.equals(item)) {
            return null;
        }
        return null;
    }
}
