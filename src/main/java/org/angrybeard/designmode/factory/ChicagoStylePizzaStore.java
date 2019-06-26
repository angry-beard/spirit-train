package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizza.*;

/**
 * Created by angry_beary on 2019/6/26.
 */
public class ChicagoStylePizzaStore extends PizzaStore {

    private PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

    @Override
    protected Pizza createPizza(PizzaItem item) {
        Pizza pizza = createPizza(item, ingredientFactory);
        pizza.setName("Chicago " + item.toString().toLowerCase());
        return pizza;
    }
}
