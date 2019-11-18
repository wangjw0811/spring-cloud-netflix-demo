package com.example.api;

import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user-server", fallbackFactory = UserFallBackFactory.class, primary = false)
public interface UserApi {

    @RequestMapping(path = "api/user",method = RequestMethod.POST)
    Integer createUser(PostUser user);

    @RequestMapping(path = "api/user/{id}",method = RequestMethod.GET)
    UserVO getUser(@PathVariable("id") int id);

    @RequestMapping(path = "api/user",method = RequestMethod.PUT)
    Integer updateUser(PutUser user);

    @RequestMapping(path = "api/user/{id}",method = RequestMethod.DELETE)
    Boolean deleteUser(@PathVariable("id") int id);

    @RequestMapping(path = "api/user/{current}/{size}",method = RequestMethod.GET)
    List<UserVO> getUsers(@PathVariable("current")int current, @PathVariable("size")int size);

}
