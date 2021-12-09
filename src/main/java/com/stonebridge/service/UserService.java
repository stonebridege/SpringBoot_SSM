package com.stonebridge.service;

import com.stonebridge.domain.User;
import com.stonebridge.mapper.mybatisExample.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    UserMapper userMapper;

    JdbcTemplate jdbcTemplateExp;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    @Qualifier("jdbcTemplateExp")
    public void setJdbcTemplateExp(JdbcTemplate jdbcTemplateExp) {
        this.jdbcTemplateExp = jdbcTemplateExp;
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
    }

    @Transactional
    public void updateUser(Integer id) {
        userMapper.updateUserById(id, "trump", "Trump");
    }

    public List<Map<String, Object>> queryList() {
        return jdbcTemplateExp.queryForList("SELECT * FROM tb_user");
    }
}
