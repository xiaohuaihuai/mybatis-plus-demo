package com.example.mybatis.plus.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis.plus.demo.dto.PagedRequest;
import com.example.mybatis.plus.demo.dto.PagedResponse;
import com.example.mybatis.plus.demo.mapper.UserMapper;
import com.example.mybatis.plus.demo.model.User;
import com.example.mybatis.plus.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public PagedResponse<User> queryPage(PagedRequest<User> req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<User> userList = this.baseMapper.queryList(req.getReqObj());
        return new PagedResponse<>(userList);
    }
}
