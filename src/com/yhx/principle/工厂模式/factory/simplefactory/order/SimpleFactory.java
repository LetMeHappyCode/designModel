package com.yhx.principle.工厂模式.factory.simplefactory.order;

import com.yhx.principle.工厂模式.factory.simplefactory.pizzastore.GreekPizza;
import com.yhx.principle.工厂模式.factory.simplefactory.pizzastore.PepperPizza;
import com.yhx.principle.工厂模式.factory.simplefactory.pizzastore.Pizza;

public class SimpleFactory {

    public Pizza createPizza(String orderType){

        Pizza pizza=null;
        if (orderType.equals("greek")){
            pizza =new GreekPizza();
            pizza.setName("希腊披萨");
        }else if (orderType.equals("pepper")){
            pizza=new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }
}
