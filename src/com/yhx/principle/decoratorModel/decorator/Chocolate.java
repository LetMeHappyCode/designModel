package com.yhx.principle.decoratorModel.decorator;

import com.yhx.principle.decoratorModel.Component.Drink;

public class Chocolate extends Decarator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }
}
