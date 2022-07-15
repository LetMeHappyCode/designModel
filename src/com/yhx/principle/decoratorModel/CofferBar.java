package com.yhx.principle.decoratorModel;

import com.yhx.principle.decoratorModel.Component.DeCaf;
import com.yhx.principle.decoratorModel.Component.Drink;
import com.yhx.principle.decoratorModel.decorator.Chocolate;

public class CofferBar {
    public static void main(String[] args) {
        //1.点一份decaf
        Drink order=new DeCaf();

        System.out.println("花费"+order.cost());
        System.out.println("描述"+order.getDes());

        //加料
        order =new Chocolate(order);

        System.out.println("花费"+order.cost());
        System.out.println("描述"+order.getDes());

        //加料
        order =new Chocolate(order);

        System.out.println("花费"+order.cost());
        System.out.println("描述"+order.getDes());
    }
}
