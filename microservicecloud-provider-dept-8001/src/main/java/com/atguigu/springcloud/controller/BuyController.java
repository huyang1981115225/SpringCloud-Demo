package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.atguigu.springcloud.service.TestTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huyang on 2019/9/27.
 */
@RestController
public class BuyController {

    @Autowired
    private TestTransactionalService service;

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buy()
    {
        String result = "Buy Success";
        boolean flag = service.buy();
        if (flag = false){
            result = "Buy Fail";
        }
        return result;
    }
}
