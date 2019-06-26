package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizzaingredieent.*;

/**
 * Created by angry_beary on 2019/6/26.
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPerpperoni();

    Clams createClam();

}
