package com.example.mybatis.plus.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis.plus.demo.dto.PaginationRequest;
import com.example.mybatis.plus.demo.dto.PaginationResponse;
import com.example.mybatis.plus.demo.model.User;

public interface UserService extends IService<User> {
    PaginationResponse<User> queryPage(PaginationRequest<User> req);
}
