package com.stonebridge;

import com.stonebridge.domain.Goods;
import com.stonebridge.domain.User;
import com.stonebridge.service.GoodsService;
import com.stonebridge.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootSsmApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @Test
    void testGetUser() {
//        List<User> list = userMapper.selectList(null);
//        for (User user : list) {
//            System.out.println(user);
//        }
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    void testSelectList() {
        List<User> list = userService.selectList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    void testSelectListGoods() {
        List<Goods> list = goodsService.queryAll();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    @Test
    void testSaveUser() {
        userService.saveUser();
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(5);
    }
}
