package com.atguigu.springcloud.entities;

/**
 * Created by huyang on 2019/9/27.
 */
public class Book {

    // 库存 默认1000本
    private Integer number;

    // 单价
    private  Integer price;

    public Book() {
    }

    public Book(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", price=" + price +
                '}';
    }
}
