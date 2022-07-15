package com.yhx.principle.工厂模式.factory.simplefactory.pizzastore;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给希腊披萨 准备原材料");
    }
}
