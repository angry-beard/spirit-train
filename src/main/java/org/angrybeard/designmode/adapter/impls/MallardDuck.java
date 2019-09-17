package org.angrybeard.designmode.adapter.impls;

import org.angrybeard.designmode.adapter.Duck;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("quack!");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
