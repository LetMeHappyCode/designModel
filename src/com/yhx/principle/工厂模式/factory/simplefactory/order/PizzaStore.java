package com.yhx.principle.工厂模式.factory.simplefactory.order;

public class PizzaStore {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

       // 使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("~~退出程序~~");

    }


}

