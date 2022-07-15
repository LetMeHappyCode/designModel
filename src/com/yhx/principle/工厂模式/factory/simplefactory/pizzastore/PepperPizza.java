package com.yhx.principle.工厂模式.factory.simplefactory.pizzastore;

public class PepperPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料");
    }
}
