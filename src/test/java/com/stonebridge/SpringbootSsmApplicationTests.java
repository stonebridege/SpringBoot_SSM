package com.stonebridge;

import com.stonebridge.domain.Goods;
import com.stonebridge.domain.User;
import com.stonebridge.service.GoodsService;
import com.stonebridge.service.UserService;
import com.stonebridge.utils.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootSsmApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    /**
     * user测试mybatis自己写的方法
     */
    @Test
    void testGetUser() {
        User user = userService.getUserById(13);
        System.out.println(user);
    }

    /**
     * user测试mybatis plus的方法
     */
    @Test
    void testSelectList() {
        List<User> list = userService.selectList();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * user测试jdbcTemplate的方法
     */
    @Test
    void testQueryList() {
        List<Map<String, Object>> list = userService.queryList();
        System.out.println(list.get(0).get("user_name"));
    }

    /**
     * Goods测试mybatis自己写的方法
     */
    @Test
    void testQueryGoodsById() {
        System.out.println(goodsService.getGoodsById(1));
    }

    /**
     * Goods测试mybatis plus的方法
     */
    @Test
    void testSelectListGoods() {
        List<Goods> list = goodsService.queryAll();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    /**
     * Goods测试jdbcTemplate的方法
     */
    @Test
    void testJdbcTemplate() {
        Map<String, Object> map = goodsService.queryGoodsById(1);
        System.out.println(StrUtil.trim(map.get("goods_name")));
    }
}
