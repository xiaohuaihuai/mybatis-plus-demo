package com.example.mybatis.plus.demo.controller;

import com.example.mybatis.plus.demo.dto.PaginationRequest;
import com.example.mybatis.plus.demo.dto.PaginationResponse;
import com.example.mybatis.plus.demo.model.User;
import com.example.mybatis.plus.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/queryPage")
    public ResponseEntity<PaginationResponse<User>> queryPage(@RequestBody PaginationRequest<User> req){
        PaginationResponse<User> resp = userService.queryPage(req);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/queryList")
    public ResponseEntity<List<User>> queryList(){
        List<User> resp = userService.list();
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody User user){
        boolean resp = userService.save(user);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody User user){
        boolean resp = userService.updateById(user);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Long[] userIds){
        boolean resp = userService.removeByIds(Arrays.asList(userIds));
        return ResponseEntity.ok(resp);
    }

}
