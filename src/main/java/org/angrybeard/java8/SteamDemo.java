package org.angrybeard.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by angry_beary on 2019/8/30.
 */
public class SteamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("I am a boy");
        list.add("I love a girl");
        list.add("but the girl love anather girl");
        List<String> newList = list.stream().map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(newList);
    }
}
