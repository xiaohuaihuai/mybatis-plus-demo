package com.example.mybatis.plus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.plus.demo.model.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> queryList(User user);
}
