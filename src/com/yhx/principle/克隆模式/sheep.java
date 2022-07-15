package com.yhx.principle.克隆模式;

public class sheep implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
