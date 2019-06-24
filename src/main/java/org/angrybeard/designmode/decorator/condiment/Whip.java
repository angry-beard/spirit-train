package org.angrybeard.designmode.decorator.condiment;

import org.angrybeard.designmode.decorator.Beverage;
import org.angrybeard.designmode.decorator.CondimentDecorator;

import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Whip";
    }

    @Override
    public BigDecimal cost() {
        return beverage.cost().add(new BigDecimal("1.2"));
    }
}
