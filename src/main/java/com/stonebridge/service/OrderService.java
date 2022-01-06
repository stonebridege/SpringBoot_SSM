package com.stonebridge.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.stonebridge.domain.Order;
import com.stonebridge.mapper.testdb.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@DS("testdb")
public class OrderService {
    OrderMapper orderMapper;

    JdbcTemplate jdbcTemplateTestDB;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Autowired
    @Qualifier("jdbcTemplateTestDB")
    public void setJdbcTemplateTestDB(JdbcTemplate jdbcTemplateTestDB) {
        this.jdbcTemplateTestDB = jdbcTemplateTestDB;
    }

    public Map<String, Object> queryOrderById(Integer id) {
        return jdbcTemplateTestDB.queryForMap("SELECT * FROM sp_order WHERE order_id=?", new Object[]{id});
    }


    public List<Order> queryAll() {
        return orderMapper.selectList(null);
    }


    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }
}
