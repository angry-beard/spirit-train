package org.angrybeard.designmode.adapter;

import org.angrybeard.designmode.adapter.adapters.TurkeyAdapter;
import org.angrybeard.designmode.adapter.impls.MallardDuck;
import org.angrybeard.designmode.adapter.impls.WildTurkey;

public class DuckTestDrive {

    public static void main(String[] args) {

        MallardDuck mallardDuck = new MallardDuck();
        WildTurkey wildTurkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);

        System.out.println("The Turkey says...");
        wildTurkey.gobble();
        wildTurkey.fly();

        System.out.println("The Duck says...");
        testDuck(mallardDuck);

        System.out.println("The TurkeyAdapter says...");
        testDuck(turkeyAdapter);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
