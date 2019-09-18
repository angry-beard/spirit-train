package org.angrybeard.designmode.template;

import org.angrybeard.designmode.template.up01.CoffeeV1;
import org.angrybeard.designmode.template.up01.TeaV1;

public class ExecuteTemplate {

    public static void main(String[] args) {
        new CoffeeV1().prepareRecipe();
        System.out.println("---------------------");
        new TeaV1().prepareRecipe();
    }
}
