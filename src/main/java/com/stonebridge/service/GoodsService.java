package com.stonebridge.service;

import com.stonebridge.domain.Goods;
import com.stonebridge.mapper.mydb.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }


    public List<Goods> queryAll() {
        return goodsMapper.selectList(null);
    }
}
