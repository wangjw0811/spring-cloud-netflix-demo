package com.example.api;

import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserHystrix implements UserApi {

    @Override
    public Integer createUser(PostUser user) {
        log.error("服务异常，创建用户信息失败");
        return null;
    }

    @Override
    public UserVO getUser(int id) {
        log.error("服务异常，查询用户信息失败");
        return null;
    }

    @Override
    public Integer updateUser(PutUser user) {
        log.error("服务异常，更新用户信息失败");
        return null;
    }

    @Override
    public Boolean deleteUser(int id) {
        log.error("服务异常，删除用户信息失败");
        return false;
    }

    @Override
    public List<UserVO> getUsers(int current, int size) {
        log.error("服务异常，搜索用户列表信息失败");
        return null;
    }
}
