package org.angrybeard.designmode.template.up01;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected boolean customerWantsCondiments() {
        return true;
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    private void pourInCup() {
        System.out.println("把饮料倒入杯子！");
    }

    private void boilWater() {
        System.out.println("把水煮沸！");
    }
}
