package org.angrybeard.designmode.decorator.beverage;

import org.angrybeard.designmode.decorator.Beverage;

import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(3);
    }
}
