package com.yhx.annotation.a2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解类
@Target(ElementType.FIELD) //用于限制当前自定义注解类的作用的对象
//@Retention(RetentionPolicy.SOURCE) //该注解类只会在源码中出现，当将源码编译成注解码时，注解信息就会被清除
//@Retention(RetentionPolicy.CLASS) //该注解类会被编译到注解码中，但是当虚拟机加载字节码时，注解信息会被清除
@Retention(RetentionPolicy.RUNTIME) //该注解类，永远保留到被加载到虚拟机中
public @interface ViewInject {
    int age();
    String name();
}