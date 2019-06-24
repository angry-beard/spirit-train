package org.angrybeard.designmode.decorator.beverage;

import org.angrybeard.designmode.decorator.Beverage;

import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(2);
    }
}
