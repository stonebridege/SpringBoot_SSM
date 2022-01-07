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
@TableName("sp_goods")
public class Goods {
    @TableId(type = IdType.AUTO, value = "goods_id")
    private Long goodsId;
    @TableField(value = "goods_name")
    private String goodsName;
    @TableField(value = "goods_price")
    private Long goodsPrice;
    @TableField(value = "goods_number")
    private Integer goodsNumber;
    @TableField(value = "goods_weight")
    private Double goodsWeight;
    @TableField(value = "cat_id")
    private Double catId;
    @TableField(value = "goods_introduce")
    private String goodsIntroduce;
}
