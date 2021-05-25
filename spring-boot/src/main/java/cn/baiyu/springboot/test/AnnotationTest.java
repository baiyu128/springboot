package cn.baiyu.springboot.test;

import cn.baiyu.springboot.annotation.MyAnnotation;

import java.lang.annotation.ElementType;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/25
 */
@MyAnnotation(name = "张三", age = 15, like = {"篮球", "看书"},TYPE = ElementType.TYPE)
public class AnnotationTest {
    public static void main(String[] args) {
        // 获取该类的字节码文件对象
        Class<AnnotationTest> aClass = AnnotationTest.class;
        // 获取注解对象
        MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
        System.out.println("获取注解的属性值 ========");
        System.out.println(annotation.name());
        System.out.println(annotation.age());
        String[] like = annotation.like();
        for (String s : like) {
            System.out.println(s);
        }
        System.out.println(annotation.TYPE());
        System.out.println(annotation.isMan());
    }
}
