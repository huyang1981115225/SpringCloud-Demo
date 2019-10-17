package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Account;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.Order;

/**
 * Created by huyang on 2019/9/27.
 */
public interface TestTransactionalService {

    int updateBook(Book book);

    int updateAccount(Account account);

    boolean addOrder(Order order);

    boolean buy();

}
