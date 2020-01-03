package com.example.mybatis.plus.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis.plus.demo.dto.PagedRequest;
import com.example.mybatis.plus.demo.dto.PagedResponse;
import com.example.mybatis.plus.demo.model.User;

public interface UserService extends IService<User> {
    PagedResponse<User> queryPage(PagedRequest<User> req);
}
