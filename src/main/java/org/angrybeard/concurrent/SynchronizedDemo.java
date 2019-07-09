package org.angrybeard.concurrent;

/**
 * Created by angry_beary on 2019/7/4.
 */
public class SynchronizedDemo implements Runnable {

    static volatile int i = 0;
    static SynchronizedDemo demo = new SynchronizedDemo();

    public static void main(String[] args) throws InterruptedException {
        for (int b = 0; b < 2; b++) {
            Thread thread = new Thread(demo);
            thread.start();
            thread.join();
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        synchronized (SynchronizedDemo.class) {
            for (int j = 0; j < 1000000; j++) {
                i++;
            }
        }
    }
}
