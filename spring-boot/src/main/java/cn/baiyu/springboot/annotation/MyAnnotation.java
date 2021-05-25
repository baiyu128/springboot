package cn.baiyu.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name();
    // 定义注解属性默认值为12
    int age() default 12;

    // 定义一个数组,使用时必填
    String[] like();

    // 定义一个数组,默认为空，使用时选填
    String[] boll() default {};

    // 定义一个布尔值类型属性
    boolean isMan() default true;

    // 定义一个枚举值
    ElementType TYPE();

    // 错误定义示范
    //void show();
}
