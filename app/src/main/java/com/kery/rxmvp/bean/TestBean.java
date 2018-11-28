package com.kery.rxmvp.bean;

/**
 * Author: TFJ
 * Date: 2017/10/11.
 */

public class TestBean {
  private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
