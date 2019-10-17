package com.atguigu.springcloud.entities;

/**
 * Created by huyang on 2019/9/27.
 */
public class Account {

    private Integer money;

    public Account() {
    }

    public Account(Integer money) {
        this.money = money;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;

    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                '}';
    }
}