package com.yhx.principle.工厂模式.factory.simplefactory.order;

import com.yhx.principle.工厂模式.factory.simplefactory.pizzastore.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza=null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }


    public void setFactory(SimpleFactory simpleFactory){
        String orderType = ""; //用户输入的

        this.simpleFactory=simpleFactory;

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            if (pizza!=null){
                pizza.prepare();
                pizza.babk();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购披萨失败");
                break;
            }

        }while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
