package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    boolean addOrder(Order order);
}
