package org.angrybeard.collection;

import java.util.LinkedList;

/**
 * Created by angry_beary on 2019/6/24.
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList.get(3));
    }
}
