package org.angrybeard.designmode.decorator.condiment;

import org.angrybeard.designmode.decorator.Beverage;
import org.angrybeard.designmode.decorator.CondimentDecorator;

import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(1).add(beverage.cost());
    }
}
