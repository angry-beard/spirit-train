package org.angrybeard.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by angry_beary on 2019/6/20.
 */
public class DrinkRunner {

    public void drink(Class clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = clazz.getDeclaredMethods();//获取对象声明的方法集合
        List<Method> methodList = new ArrayList<Method>();//@Test注解的方法集合
        for (Method method : methods) {//循环对象声明的所有方法
            methodList.add(method);
        }
        //new一个对象实例
        Object obj = clazz.newInstance();
        //反射激活方法
        for (Method m : methodList) {
            m.invoke(obj, null);
        }
    }
}
