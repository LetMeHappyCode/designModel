package com.yhx.principle.工厂模式.factory.simplefactory.pizzastore;

public abstract class Pizza {
    protected String name;

    //准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
    public abstract void prepare();

    public void babk(){
        System.out.println(name+"babking");
    }


    public void cut(){
        System.out.println(name+"cutting");
    }

    public void box(){
        System.out.println(name+"boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}
