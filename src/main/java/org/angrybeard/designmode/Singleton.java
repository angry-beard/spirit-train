package org.angrybeard.designmode;

/**
 * Created by angry_beary on 2019/6/23.
 * 单例对象 占用资源少，不需要延时加载，枚举 好于 饿汉
 * 单例对象 占用资源多，需要延时加载，静态内部类 好于 懒汉式
 */
public class Singleton {

    private static volatile Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (null == SINGLETON) {
            synchronized (Singleton.class) {
                if (null == SINGLETON) {
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }

    public void sayHello() {
        System.out.println("hello world");
    }
}
