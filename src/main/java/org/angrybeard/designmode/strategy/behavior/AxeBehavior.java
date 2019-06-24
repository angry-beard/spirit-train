package org.angrybeard.designmode.strategy.behavior;

import org.angrybeard.designmode.strategy.WeaponBehavior;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class AxeBehavior implements WeaponBehavior {

    @Override
    public void userWeapon() {
        System.out.println("用斧头砍");
    }
}
