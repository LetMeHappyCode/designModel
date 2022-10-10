package com.yhx.annotation.a2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationMainTest {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //需求：获取User类中name字段上的自定义注解的值，
        //然后将该值的age通过反射设置给User对象的age属性，将name设置给User对象的name属性

        User user = new User();
        /**
         * 1.获取User类的字节码
         */
//      user.getClass();
//      User.class;
//      Class.forName("");
        Class clazz= User.class;
        /**
         * 2.将字节码中的name字段获取到
         */
//      clazz.getField("");//只能获取声明为public的字段
        Field declaredField = clazz.getDeclaredField("name");
        Field declaredFieldAge = clazz.getDeclaredField("age");

        /**
         * 3.将当前字段上的注解对象获取到
         */
        ViewInject viewInject =  declaredField.getAnnotation(ViewInject.class);
        if (viewInject != null) {
            /**
             * 4.获取自定义注解对象的参数
             */
            int age = viewInject.age();
            String name = viewInject.name();

            System.out.println("name="+name+",age="+age);
            /**
             * 5.通过反射将这两个值反射给User对象
             */
            declaredField.setAccessible(true); //设置允许访问，其实就是允许暴力反射
            declaredFieldAge.setAccessible(true);
            //将user对象的declaredField设置为name
            declaredField.set(user, name);
            declaredFieldAge.set(user, age);
            System.out.println(user.toString());
        }else {
            System.out.println("字段上面没有自定义注解");
        }
        //通过反射调用eat对象的方法
        Method declaredMethod = clazz.getDeclaredMethod("eat", String.class);
        //设置允许访问
        declaredMethod.setAccessible(true);
        //暴力反射调用该方法
        Object result = declaredMethod.invoke(user, "牛肉拉面");
        System.out.println(result);
    }
}

