package com.lgd.proxy;

public class Person implements Subject{
    @Override
    public void shopping() {
        System.out.println("付款，买到心仪的衣服");
    }
}
