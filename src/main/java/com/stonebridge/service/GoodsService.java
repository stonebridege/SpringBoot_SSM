package com.stonebridge.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.stonebridge.domain.Goods;
import com.stonebridge.mapper.mydb.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DS("mydb")
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    @Qualifier("jdbcTemplateMydb")
    JdbcTemplate jdbcTemplateMydb;

    public Map<String, Object> queryGoodsById(Integer id) {
        return jdbcTemplateMydb.queryForMap("SELECT * FROM sp_goods WHERE goods_id=?", new Object[]{id});
    }


    public List<Goods> queryAll() {
        return goodsMapper.selectList(null);
    }


    public Goods getGoodsById(Integer id) {
        return goodsMapper.getGoodsById(id);
    }
}
