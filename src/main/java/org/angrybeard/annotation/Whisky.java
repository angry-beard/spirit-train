package org.angrybeard.annotation;

/**
 * Created by angry_beary on 2019/6/20.
 */
public class Whisky {

    @Drink
    public void placeOfOrigin() {
        System.out.println("产自法国西南部的阿曼涅克");
    }

    @Drink
    public void price() {
        System.out.println("126人民币");
    }

    @RedWine(time = "82", price = 88888)
    public void loveWine() {
        System.out.println("红酒哇");
    }
}
