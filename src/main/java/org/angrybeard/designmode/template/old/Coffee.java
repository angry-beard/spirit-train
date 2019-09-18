package org.angrybeard.designmode.template.old;

public class Coffee {

    public void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }

    private void addSugarAndMilk() {
        System.out.println("添加糖和牛奶！");
    }

    private void pourInCup() {
        System.out.println("把咖啡倒入杯子！");
    }

    private void brewCoffeeGrinds() {
        System.out.println("用沸水冲泡咖啡！");
    }

    private void boilWater() {
        System.out.println("把水煮沸！");
    }
}
