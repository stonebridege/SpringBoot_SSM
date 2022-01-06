package com.stonebridge.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sp_order")
public class Order {
    @TableId(type = IdType.AUTO, value = "order_id")
    private Integer orderId;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "order_number")
    private String orderNumber;
    @TableField(value = "order_price")
    private Double orderPrice;
}
