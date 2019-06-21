package org.angrybeard.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;

/**
 * Created by angry_beary on 2019/6/20.
 *
 * @Retention（保留期） 应用到一个注解上的时候，它解释说明了这个注解的的存活时间
 * RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
 * RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
 * RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
 * @Documented 将注解中的元素包含到 Javadoc 中去
 * @Target 注解运用的地方
 * ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 * ElementType.CONSTRUCTOR 可以给构造方法进行注解
 * ElementType.FIELD 可以给属性进行注解
 * ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 * ElementType.METHOD 可以给方法进行注解
 * ElementType.PACKAGE 可以给一个包进行注解
 * ElementType.PARAMETER 可以给一个方法内的参数进行注解
 * ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 * @Inherited (继承)
 * 如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解
 * @Repeatable(可重复) Java 1.8 才加进来的
 *
 * 注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RedWine {

    String time() default "";

    double price();

}