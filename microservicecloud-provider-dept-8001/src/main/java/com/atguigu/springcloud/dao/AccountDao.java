package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountDao
{
	int updateAccount(Account account);
}
