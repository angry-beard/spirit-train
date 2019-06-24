package org.angrybeard.designmode.strategy;

import org.angrybeard.designmode.strategy.behavior.AxeBehavior;
import org.angrybeard.designmode.strategy.behavior.BowAndArrowBehavior;
import org.angrybeard.designmode.strategy.behavior.KnifeBehavior;
import org.angrybeard.designmode.strategy.behavior.SwordBehavior;
import org.angrybeard.designmode.strategy.role.King;
import org.angrybeard.designmode.strategy.role.Knight;
import org.angrybeard.designmode.strategy.role.Queen;
import org.angrybeard.designmode.strategy.role.Troll;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class Fighting {

    public static void main(String[] args) {
        new King(new AxeBehavior()).fight();
        new Queen(new BowAndArrowBehavior()).fight();
        new Knight(new SwordBehavior()).fight();
        new Troll(new KnifeBehavior()).fight();
    }
}
