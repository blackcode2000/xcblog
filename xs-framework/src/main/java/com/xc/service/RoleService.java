package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-04-21 16:41:02
 */
public interface RoleService extends IService<Role> {

    List<String> selectRoleKeyByUserId(Long id);
}
