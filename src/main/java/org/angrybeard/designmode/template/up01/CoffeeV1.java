package org.angrybeard.designmode.template.up01;

public class CoffeeV1 extends CaffeineBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("添加糖和牛奶！");
    }

    @Override
    protected void brew() {
        System.out.println("用沸水冲泡咖啡！");
    }
}
