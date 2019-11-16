package com.example.web.controller;

import com.example.api.UserApi;
import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import utils.ResponseData;

import java.util.List;

@RequestMapping("/web/user")
@RestController
public class UserController {

    @Autowired
    private UserApi userApi;


    @PostMapping
    public ResponseData createUser(@RequestBody PostUser user){
        Integer userId = userApi.createUser(user);
        if(userId != null){
            return ResponseData.success(userId);
        }
        return ResponseData.failure();
    }

    @PutMapping
    public ResponseData updateUser(@Validated @RequestBody PutUser user){
        Integer userId = userApi.updateUser(user);
        if(userId != null){
            return ResponseData.success(userId);
        }
        return ResponseData.failure();
    }

    @GetMapping("/{current}/{size}")
    public ResponseData<List<UserVO>> getUsers(@PathVariable(name="current") int current, @PathVariable(name="size") int size){
        List<UserVO> users = userApi.getUsers(current, size);
        return ResponseData.success(users);
    }

    @GetMapping("/{id}")
    public ResponseData<UserVO> getUser(@PathVariable int id){
        System.out.println("获取用户信息");
        UserVO user = userApi.getUser(id);
        return ResponseData.success(user);
    }

    @DeleteMapping("/{id}")
    public ResponseData<String> deleteUser(@PathVariable int id){
        Boolean ok = userApi.deleteUser(id);
        if(ok){
            return ResponseData.success("订单删除成功");
        }
        return ResponseData.failure("订单删除失败");
    }

}
