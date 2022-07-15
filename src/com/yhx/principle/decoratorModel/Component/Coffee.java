package com.yhx.principle.decoratorModel.Component;

public class Coffee extends Drink{
    @Override
    public float cost() {
        return super.getPrice();
    }
}
