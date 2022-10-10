package com.yhx.principle.decoratorModel.decorator;

import com.yhx.principle.decoratorModel.Component.Drink;

public class Decarator extends Drink {

    private Drink obj;

    public Decarator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        return super.getPrice()+obj.cost();
    }

    @Override
    public String getDes() {
        return des+""+getPrice()+"&&"+obj.getDes();
    }
}


