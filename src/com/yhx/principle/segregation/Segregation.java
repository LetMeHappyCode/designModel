package com.yhx.principle.segregation;

public class Segregation {

    public static void main(String[] args) {
        A a=new A();
        a.depend1(new B());
    }
}

//接口1
interface Interface1{
    void operation1();
}


//接口2
interface Interface2{
    void operation2();
    void operation3();
}


//接口1
interface Interface3{
    void operation4();
    void operation5();
}


class B implements Interface1,Interface2{

    @Override
    public void operation1() {
        System.out.println("B 实现 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现 operation3");
    }
}

class D implements Interface1,Interface3{

    @Override
    public void operation1() {
        System.out.println("B 实现 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("B 实现 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现 operation5");
    }
}

class A{
    public void depend1(Interface1 i){
        i.operation1();
    }

    public void depend2(Interface2 i){
        i.operation2();
    }

    public void depend3(Interface2 i){
        i.operation3();
    }
}