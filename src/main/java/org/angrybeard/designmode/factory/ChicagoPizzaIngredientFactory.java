package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizzaingredieent.*;

/**
 * Created by angry_beary on 2019/6/26.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[0];
    }

    @Override
    public Pepperoni createPerpperoni() {
        return null;
    }

    @Override
    public Clams createClam() {
        return null;
    }
}
