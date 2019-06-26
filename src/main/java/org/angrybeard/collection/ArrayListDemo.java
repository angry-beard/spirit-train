package org.angrybeard.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by angry_beary on 2019/6/21.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> words = new ArrayList();
        System.out.println(words.size());
        System.out.println(1 << 30);
        System.out.println(1 << 4);
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = 17 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
        int h;
        Object object = new Object();
        System.out.println(object.hashCode());
        System.out.println((object == null) ? 0 : (h = object.hashCode()) ^ (h >>> 16));
        System.out.println((object == null) ? 0 : (h = object.hashCode()) ^ (h >>> 16));
    }
}
//1 2