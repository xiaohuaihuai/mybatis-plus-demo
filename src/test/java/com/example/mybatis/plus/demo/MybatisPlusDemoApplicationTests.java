package com.example.mybatis.plus.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.plus.demo.mapper.UserMapper;
import com.example.mybatis.plus.demo.mapper.UserMapper2;
import com.example.mybatis.plus.demo.model.User;
import com.example.mybatis.plus.demo.model.User2;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private UserMapper2 userMapper2;

    @Test
    public void testSequence() {
        User user = User.builder()
                .name("test11")
                .age(18)
                .email("test11@qq.com")
                .build();
        userMapper.insert(user);
        System.out.println(user.getId());
        User user11 = userMapper.selectById(user.getId());
        System.out.println(user11);
    }

    @Test
    public void testIdGenerator() {
        User2 user2 = User2.builder()
                .name("test12")
                .age(12)
                .email("test12@qq.com")
                .build();
        userMapper2.insert(user2);
        System.out.println(user2.getId());
        User2 user12 = userMapper2.selectById(user2.getId());
        System.out.println(user12);
    }

    @Test
    public void testInsert() {
        User user = User.builder()
                .id(11L)
                .name("test11")
                .age(18)
                .email("test11@qq.com")
                .build();
        userMapper.insert(user);
        User user11 = userMapper.selectById(11L);
        System.out.println(user11);
    }

    @Test
    public void testUpdateById() {
        User user = User.builder()
                .id(1L)
                .name("test1")
                .age(111)
                .email("test1@qq.com")
                .build();
        userMapper.updateById(user);
        User user1 = userMapper.selectOne(new QueryWrapper<User>().eq("id", 1L));
        System.out.println(user1);
    }

    @Test
    public void testDeleteBatchIds() {
        userMapper.deleteBatchIds(Arrays.asList(1L, 3L));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testQueryList() {
        User user = User.builder()
                .age(18)
                .build();
        PageHelper.startPage(2, 3);
        List<User> userList = userMapper.queryList(user);
        userList.forEach(System.out::println);
    }
}
