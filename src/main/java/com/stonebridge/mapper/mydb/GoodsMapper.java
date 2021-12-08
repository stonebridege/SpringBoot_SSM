package com.stonebridge.mapper.mydb;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stonebridge.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("mydb")
public interface GoodsMapper extends BaseMapper<Goods> {
}
