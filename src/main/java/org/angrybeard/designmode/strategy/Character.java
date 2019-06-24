package org.angrybeard.designmode.strategy;

/**
 * Created by angry_beary on 2019/6/23.
 */
public abstract class Character {

    protected WeaponBehavior weaponBehavior;

    public void fight() {
        weaponBehavior.userWeapon();
    }

    public Character(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
