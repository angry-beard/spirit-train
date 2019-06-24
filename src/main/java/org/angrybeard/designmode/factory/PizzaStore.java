package org.angrybeard.designmode.factory;

/**
 * Created by angry_beary on 2019/6/24.
 */
public abstract class PizzaStore {

    public Product orderPizza(String item) {
        Product pizza = createPizza(item);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Product createPizza(String item);


}
