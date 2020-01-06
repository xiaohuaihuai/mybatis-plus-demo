package com.example.mybatis.plus.demo.controller;

import com.example.mybatis.plus.demo.dto.PagedRequest;
import com.example.mybatis.plus.demo.dto.PagedResponse;
import com.example.mybatis.plus.demo.model.User;
import com.example.mybatis.plus.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryPage", method = RequestMethod.POST)
    public ResponseEntity<PagedResponse<User>> queryPage(@RequestBody PagedRequest<User> req){
        PagedResponse<User> resp = userService.queryPage(req);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public ResponseEntity<List<User>> queryList(){
        List<User> resp = userService.list();
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Boolean> create(@RequestBody User user){
        boolean resp = userService.save(user);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Boolean> update(@RequestBody User user){
        boolean resp = userService.updateById(user);
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Boolean> delete(@RequestBody Long[] userIds){
        boolean resp = userService.removeByIds(Arrays.asList(userIds));
        return ResponseEntity.ok(resp);
    }

}
