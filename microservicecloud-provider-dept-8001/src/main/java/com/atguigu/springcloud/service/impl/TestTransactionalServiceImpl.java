package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.AccountDao;
import com.atguigu.springcloud.dao.BookDao;
import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.entities.Account;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.Order;
import com.atguigu.springcloud.service.TestTransactionalService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huyang on 2019/9/27.
 */
@Service
public class TestTransactionalServiceImpl implements TestTransactionalService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public int updateBook(Book book) {
        System.out.println("updateBook()-----"+this.getClass().getName());
        return bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public int updateAccount(Account account) {
        System.out.println("updateAccount()-----"+this.getClass().getName());
        int result = accountDao.updateAccount(account);
        int a = 1/0;//制造异常
        return result ;
    }

    @Override
    @Transactional
    public boolean addOrder(Order order) {
        System.out.println("addOrder()-----"+this.getClass().getName());
        return orderDao.addOrder(order);
    }

    /**
     * 模拟购买一本书，库存、账户、订单
     */
    @Override
    @Transactional
    public boolean buy() {
        System.out.println("buy()-----"+this.getClass().getName());
        Integer bookTotal = 1000;// 仓库开始1000本
        Integer bookPrice = 10;// 书的单价
        Integer buyNum = 1;
        Integer totalPrice = bookPrice * buyNum;//买书花费
        // 买了一本书
        Book book = new Book(bookTotal - buyNum);
//        bookDao.updateBook(book);
        updateBook(book);

        // 账户扣钱
        Integer accountTotal = 10000;// 账户里10000元
        Account account = new Account(accountTotal - totalPrice);
        try{
            /**
             * 下面仅仅是为了演示事务失效
             */
//            updateAccount(account);// 明明有异常，也加了事务注解，但是事务没有回滚
            TestTransactionalService service = (TestTransactionalService) AopContext.currentProxy();//事务会回滚  书卖了，钱没扣不符合要求
            service.updateAccount(account);
        }catch (Exception e){
            System.out.println("算了吧");
        }

        // 记录订单
        Order order = new Order(buyNum, totalPrice);
        return addOrder(order);
    }
}
