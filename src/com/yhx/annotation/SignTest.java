package com.yhx.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Sign(className = "com.yhx.annotation.Cat", methodName = "eat")
public class SignTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<SignTest> signTestClass = SignTest.class;

        Sign sign = signTestClass.getAnnotation(Sign.class);

        String className = sign.className();
        String methodName = sign.methodName();

        System.out.println(className);

        Class<?> aClass = Class.forName(className);

        Object o = aClass.newInstance();

        Method method = aClass.getMethod(methodName);

        method.invoke(o);


    }
}
