package com.example.mybatis.plus.demo.controller;

import com.example.mybatis.plus.demo.dto.PagedRequest;
import com.example.mybatis.plus.demo.dto.PagedResponse;
import com.example.mybatis.plus.demo.model.User;
import com.example.mybatis.plus.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryPage")
    public ResponseEntity<PagedResponse<User>> queryPage(@RequestBody PagedRequest<User> req){
        PagedResponse<User> resp = userService.queryPage(req);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping("/queryList")
    public ResponseEntity<List<User>> queryList(){
        List<User> resp = userService.list();
        return ResponseEntity.ok(resp);
    }

    @RequestMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody User user){
        boolean resp = userService.save(user);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody User user){
        boolean resp = userService.updateById(user);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Long[] userIds){
        boolean resp = userService.removeByIds(Arrays.asList(userIds));
        return ResponseEntity.ok(resp);
    }

}
