package com.yhx.annotation.a2;

public class User {
    @ViewInject(age=21,name="chunsoft")
    private String name;
    private int age;
    private String eat(String eat) {
        System.out.println("eat:"+eat);
        return eat + " 真好吃";
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
}
