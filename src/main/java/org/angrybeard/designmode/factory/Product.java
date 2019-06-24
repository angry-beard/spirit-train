package org.angrybeard.designmode.factory;

/**
 * Created by angry_beary on 2019/6/24.
 */
public interface Product {
    void prepare();

    void bake();

    void cut();

    void box();
}
