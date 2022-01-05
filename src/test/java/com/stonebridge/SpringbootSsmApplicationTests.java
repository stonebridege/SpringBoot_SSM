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
        // ==>  Preparing: SELECT * FROM tb_user WHERE id = ?
        // ==> Parameters: 13(Integer)
        // <==      Total: 1
        //User(id=13, userName=Trump, password=123456, name=trump, age=18, email=stonebridge@gamil.com)
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
        // ==>  Preparing: SELECT id,user_name,password,name,age,email FROM tb_user
        // ==> Parameters:
        // <==      Total: 4
        //User(id=13, userName=Trump, password=123456, name=trump, age=18, email=trump@gamil.com)
        //User(id=16, userName=Trump, password=123456, name=trump, age=18, email=trump@gamil.com)
        //User(id=17, userName=Stonebridge, password=123456, name=stonebride, age=18, email=stonebridge@gamil.com)
        //User(id=18, userName=Stonebridge, password=123456, name=stonebride, age=18, email=stonebridge@gamil.com)
    }

    /**
     * user测试jdbcTemplate的方法
     */
    @Test
    void testQueryList() {
        List<Map<String, Object>> list = userService.queryList();
        System.out.println(list.get(0).get("user_name"));
        //Trump
    }

    /**
     * Goods测试mybatis自己写的方法
     */
    @Test
    void testQueryGoodsById() {
        Goods goods = goodsService.getGoodsById(45);
        System.out.println(goods.getGoodsName());
        // ==>  Preparing: SELECT * FROM sp_goods WHERE goods_id = ?
        // ==> Parameters: 45(Integer)
        // <==      Total: 1
        //儿童玩具海洋球池婴儿帐篷宝宝热带雨林运动会投手球池投篮游戏屋波波球户外玩具
    }

    /**
     * Goods测试mybatis plus的方法
     */
    @Test
    void testSelectListGoods() {
        List<Goods> list = goodsService.queryAll();
        System.out.println(list.get(7).getGoodsName());
        // ==>  Preparing: SELECT goods_id,goods_name,goods_price,goods_number,goods_weight,cat_id,goods_introduce FROM sp_goods
        // ==> Parameters:
        // <==      Total: 927
        //PPTV-32C3 32英寸 1GB+8GB 4核 64位处理器 高清智能网络WIFI平板电视机
    }

    /**
     * Goods测试jdbcTemplate的方法
     */
    @Test
    void testJdbcTemplate() {
        Map<String, Object> map = goodsService.queryGoodsById(45);
        System.out.println(StrUtil.trim(map.get("goods_name")));
        //儿童玩具海洋球池婴儿帐篷宝宝热带雨林运动会投手球池投篮游戏屋波波球户外玩具
    }
}
