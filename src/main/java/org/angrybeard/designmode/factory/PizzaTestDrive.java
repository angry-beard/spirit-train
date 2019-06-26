package org.angrybeard.designmode.factory;

import org.angrybeard.designmode.factory.pizza.Pizza;

/**
 * Created by angry_beary on 2019/6/26.
 */
public class PizzaTestDrive {

    public static void main(String[] args) {

        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        System.out.println("Tom ordered a ny cheese");
        Pizza nyPizza = nyPizzaStore.orderPizza(PizzaItem.CHEESE);
        System.out.println("Tom get a " + nyPizza.getName());
        System.out.println("Lucy ordered a chicago cheese");
        Pizza chicagoPizza = chicagoStore.orderPizza(PizzaItem.CHEESE);
        System.out.println("Lucy get a " + chicagoPizza.getName());
    }
}
