package org.angrybeard.designmode.template.old;

public class Tea {

    public void prepareRecipe() {
        boilWater();
        brewTeaBag();
        pourInCup();
        addLemon();
    }

    private void addLemon() {
        System.out.println("添加柠檬！");
    }

    private void pourInCup() {
        System.out.println("把茶倒入杯子！");
    }

    private void brewTeaBag() {
        System.out.println("用沸水冲泡茶叶！");
    }

    private void boilWater() {
        System.out.println("把水煮沸！");
    }
}
