package org.angrybeard.annotation;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by angry_beary on 2019/6/20.
 */
public class DrinkDown {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        new DrinkRunner().drink(Whisky.class);
    }
}
