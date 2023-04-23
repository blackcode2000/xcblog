package com.xc.domain.entity;

import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 标签(Tag)表实体类
 *
 * @author makejava
 * @since 2023-04-20 19:26:36
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("xc_tag")
public class Tag  {
    @TableId
    private Long id;

    //标签名
    private String name;

    private Long createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private Long updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）

    private Integer delFlag;
    //备注
    private String remark;



}
