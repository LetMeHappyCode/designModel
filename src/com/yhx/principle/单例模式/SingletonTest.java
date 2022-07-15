package com.yhx.principle.单例模式;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton instace =Singleton.getInstace();
        Singleton instace2 =Singleton.getInstace();

        System.out.println(instace == instace2);
    }
}
