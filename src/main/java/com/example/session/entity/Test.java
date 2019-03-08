package com.example.session.entity;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019/3/8 4:04 PM
 */
public class Test {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
