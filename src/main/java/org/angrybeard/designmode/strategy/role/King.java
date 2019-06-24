package org.angrybeard.designmode.strategy.role;

import org.angrybeard.designmode.strategy.Character;
import org.angrybeard.designmode.strategy.WeaponBehavior;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class King extends Character {

    public King(WeaponBehavior weaponBehavior) {
        super(weaponBehavior);
        System.out.print("国王 ");
    }
}
