package org.angrybeard.designmode.decorator;

import org.angrybeard.designmode.decorator.beverage.Espresso;
import org.angrybeard.designmode.decorator.beverage.HouseBlend;
import org.angrybeard.designmode.decorator.condiment.Mocha;
import org.angrybeard.designmode.decorator.condiment.Soy;
import org.angrybeard.designmode.decorator.condiment.Whip;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }
}
