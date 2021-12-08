package com.stonebridge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stonebridge.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUser(Integer id);

    void updateUserById(@Param("id") Integer id, @Param("name") String name, @Param("user_name") String user_name);
}
