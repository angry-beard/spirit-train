package org.angrybeard.concurrent;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by angry_beary on 2019/6/25.
 */
public class ThreadDemo {

    public static synchronized void test1() {
        System.out.println("hello");
        test2();
    }

    public static synchronized void test2() {
        System.out.println("world");
    }

    public static void main(String[] args) {
        for(int i=1;i<1000;i++){
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    new ThreadDemo().test1();
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    new ThreadDemo().test1();
                }
            });

            thread1.start();
            thread2.start();
        }
    }
}
