package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao {

    int updateBook(Book book);
}
