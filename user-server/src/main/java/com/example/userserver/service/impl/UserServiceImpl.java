package com.example.userserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.api.dto.PostUser;
import com.example.api.dto.PutUser;
import com.example.api.vo.UserVO;
import com.example.userserver.entity.User;
import com.example.userserver.mapper.UserMapper;
import com.example.userserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public Integer createUser(PostUser user) {
        User u = new User();
        BeanUtils.copyProperties(user, u);
        boolean ok = this.save(u);
        if(ok){
            return u.getId();
        }
        return null;
    }

    public UserVO getUser(Integer id) {
        UserVO vo = new UserVO();
        User user = this.getById(id);
        BeanUtils.copyProperties(user, vo);
        return vo;
    }

    public Integer updateUser(PutUser user) {
        User u = new User();
        BeanUtils.copyProperties(user, u);
        boolean ok = this.updateById(u);
        if(ok){
            return u.getId();
        }
        return null;
    }

    public boolean deleteUser(Integer id) {
        boolean ok = this.removeById(id);
        if(ok){
            return true;
        }
        return false;
    }

    public List<UserVO> getUsers(Integer current, Integer size) {
        IPage<User> page = new Page<>(current, size);
        IPage<User> users = this.page(page);
        List<User> records = users.getRecords();
        List<UserVO> vos = new ArrayList<>();
        BeanUtils.copyProperties(records, vos);
        return vos;
    }
}
