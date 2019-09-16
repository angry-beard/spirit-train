package org.angrybeard.java8;

import java.util.Optional;

/**
 * Created by angry_beary on 2019/8/30.
 */
public class OptionalDemo {

    public static void main(String[] args) {
        System.out.println(Optional.of("saber"));
        System.out.println(Optional.ofNullable(null));
        System.out.println(Optional.ofNullable("good"));
    }
}
