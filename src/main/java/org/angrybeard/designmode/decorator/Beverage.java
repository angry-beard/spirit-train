package org.angrybeard.designmode.decorator;

import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/24.
 */
public abstract class Beverage {

    public String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal cost();
}
