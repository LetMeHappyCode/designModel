package com.yhx.principle.单例模式;

public class Singleton {
    private Singleton(){

    }

    private static volatile Singleton instace;

    public static synchronized Singleton getInstace(){
        if (instace == null){
            synchronized (Singleton.class){
                if (instace == null){
                    instace=new Singleton();
                }
            }
        }

        return instace;
    }
}
