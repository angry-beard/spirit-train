package org.angrybeard.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by angry_beary on 2019/7/3.
 */
public class Ticket {

    private static CountDownLatch ctl = new CountDownLatch(1);
    volatile Integer stock = 8;

    public void reduce(int num) {
        boolean flag = false;
        synchronized (this) {
            if ((stock - num) >= 0) {
                try {
                    ctl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stock -= num;
                flag = true;
            }
        }
        if (flag) {
            System.out.println(Thread.currentThread().getName() + "成功：卖出" + num + "张票，剩余" + stock + "张");
        } else {
            System.err.println(Thread.currentThread().getName() + "失败：库存不足" + num + "张，剩余" + stock + "张");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Ticket ticket = new Ticket();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> ticket.reduce(1), "用户" + (i + 1)).start();
        }
        Thread.sleep(1000L);
        ctl.countDown();
    }
}
