package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizza.*;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class NYPizzaStore extends PizzaStore {

    private PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

    @Override
    protected Pizza createPizza(PizzaItem item) {
        Pizza pizza = createPizza(item, ingredientFactory);
        pizza.setName("Ny " + item.toString().toLowerCase());
        return pizza;
    }
}