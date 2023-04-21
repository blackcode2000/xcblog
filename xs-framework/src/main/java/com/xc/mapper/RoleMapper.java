package com.xc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xc.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-21 16:40:58
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long userId);
}
