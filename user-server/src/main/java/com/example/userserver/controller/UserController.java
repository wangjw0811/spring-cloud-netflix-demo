package com.example.userserver.controller;


import com.example.api.UserApi;
import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import com.example.userserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-14
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserServiceImpl userApi;

    @PostMapping
    public Integer createUser(@Validated @RequestBody PostUser user){
        return userApi.createUser(user);
    }

    @PutMapping
    public Integer updateUser(@Validated @RequestBody PutUser user){
        return userApi.updateUser(user);
    }

   /* @GetMapping("/${current}/${size}")
    public List<UserVO> getUsers(@PathVariable(name="current") int current, @PathVariable(name="size") int size){
        return userApi.getUsers(current, size);
    }*/

    @GetMapping("/{id}")
    public UserVO getUser(@PathVariable(name="id") int id){
        return userApi.getUser(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable(name="id") int id){
        return userApi.deleteUser(id);
    }

}
