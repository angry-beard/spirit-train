package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizza.*;

/**
 * Created by angry_beary on 2019/6/24.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(PizzaItem item) {
        Pizza pizza = createPizza(item);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(PizzaItem item);

    protected Pizza createPizza(PizzaItem item, PizzaIngredientFactory ingredientFactory) {
        switch (item) {
            case CHEESE:
                return new CheesePizza(ingredientFactory);
            case CLAM:
                return new ClamPizza(ingredientFactory);
            case PEPPERONI:
                return new PepperoniPizza(ingredientFactory);
            case VEGGIE:
                return new VeggiePizza(ingredientFactory);
            default:
                return null;
        }
    }

}
