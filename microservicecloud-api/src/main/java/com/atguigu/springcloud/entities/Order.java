package com.atguigu.springcloud.entities;

/**
 * Created by huyang on 2019/9/27.
 */
public class Order {

    private Integer id;

    private Integer number;

    private Integer totalPrice;

    public Order() {
    }

    public Order(Integer number, Integer totalPrice) {
        this.number = number;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
