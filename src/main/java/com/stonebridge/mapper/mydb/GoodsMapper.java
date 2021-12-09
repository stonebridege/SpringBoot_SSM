package com.stonebridge.mapper.mydb;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stonebridge.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
@DS("mydb")
public interface GoodsMapper extends BaseMapper<Goods> {
    Goods getGoodsById(@Param("goods_id") Integer goods_id);
}
