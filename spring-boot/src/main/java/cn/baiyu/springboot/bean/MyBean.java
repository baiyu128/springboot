package cn.baiyu.springboot.bean;

import cn.baiyu.springboot.annotation.MyAnnotation2;
import org.springframework.stereotype.Component;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/25
 */
@Component
public class MyBean {

    @MyAnnotation2(param = "方法")
    public void test () {
        System.out.println("执行TEST方法");
    }
}
