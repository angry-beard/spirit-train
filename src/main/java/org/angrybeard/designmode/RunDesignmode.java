package org.angrybeard.designmode;

import com.sun.tools.javac.util.Abort;

import java.util.concurrent.*;

/**
 * Created by angry_beary on 2019/6/23.
 */
public class RunDesignmode {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }, (RejectedExecutionHandler) new Abort());
        for (int i = 0; i < 100; i++) {
            // executor.execute();
        }
        Singleton.getSingleton().sayHello();
    }
}
