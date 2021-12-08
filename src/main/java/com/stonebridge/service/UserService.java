package com.stonebridge.service;

import com.stonebridge.domain.User;
import com.stonebridge.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Integer id) {
        return userMapper.getUser(id);
    }

    public List<User> selectList() {
        return userMapper.selectList(null);
    }

    @Transactional
    public void saveUser() {
        User user = new User();
        user.setUserName("Stonebridge");
        user.setPassword("123456");
        user.setName("stonebride");
        user.setAge(18);
        user.setEmail("stonebridge@gamil.com");
        Integer row = userMapper.insert(user);
        System.out.println(1 / 0);
        System.out.println("影响条数：" + row);
    }

    @Transactional
    public void updateUser(Integer id) {
        userMapper.updateUserById(id, "trump", "Trump");
        System.out.println(1/0);
    }
}
