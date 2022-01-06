package com.stonebridge.mapper.testdb;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stonebridge.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
@DS("testdb")
public interface OrderMapper extends BaseMapper<Order> {
    Order getOrderById(@Param("order_id") Integer order_id);
}
