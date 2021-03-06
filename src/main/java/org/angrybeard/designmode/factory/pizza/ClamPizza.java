package org.angrybeard.designmode.factory.pizza;

import org.angrybeard.designmode.factory.PizzaIngredientFactory;

/**
 * Created by angry_beary on 2019/6/26.
 */
public class ClamPizza extends Pizza {

    PizzaIngredientFactory factory;

    public ClamPizza(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void prepare() {
        System.out.println("Perparing " + name);
        super.dough = factory.createDough();
        super.sauce = factory.createSauce();
        super.cheese = factory.createCheese();
        super.clams = factory.createClam();
    }
}
