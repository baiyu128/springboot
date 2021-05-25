package cn.baiyu.springboot.aspact;

import cn.baiyu.springboot.annotation.MyAnnotation2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/5/25
 */
@Aspect
@Component
public class MyAspect {

    // 切入点 value值表示凡是用到了MyAnnotation2这个注解的方法都被拦截
    @Pointcut(value = "@annotation(cn.baiyu.springboot.annotation.MyAnnotation2)")
    public void pointCut() {
    }

    // 前置通知，方法前执行
    @Before(value = "pointCut()")
    public void beforeMethod(JoinPoint joinPoint) throws NoSuchMethodException {
        // 获取方法签名
        Signature signature = joinPoint.getSignature();
        Method method = ((MethodSignature) signature).getMethod();
        Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(),
                method.getParameterTypes());
        MyAnnotation2 annotation = realMethod.getAnnotation(MyAnnotation2.class);
        System.out.println("方法前执行");
        System.out.println("获取到的属性值为" + annotation.param());
    }

    // 后置通知，方法执行后执行
    @After(value = "pointCut()")
    public void afterMethod() {
        System.out.println("方法后执行");
    }
}
