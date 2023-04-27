package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.ResponseResult;
import com.xc.domain.dto.RoleDto;
import com.xc.domain.dto.UpdateRoleDto;
import com.xc.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-04-21 16:41:02
 */
public interface RoleService extends IService<Role> {

    /**
     *  获取用户角色
     *  管理员返回集合只有 admin
     *  其他用户返回所有角色
     * @param id
     * @return
     */
    List<String> selectRoleKeyByUserId(Long id);

    /**
     *  分页查询角色泪飙
     * @param pageNum
     * @param pageSize
     * @param roleDto
     * @return
     */
    ResponseResult pageRoleList(Integer pageNum, Integer pageSize, RoleDto roleDto);

    /**
     *  更新角色状态
     * @param updateRoleDto
     * @return
     */
    ResponseResult updateStatusById(UpdateRoleDto updateRoleDto);

    /**
     *  新增角色
     * @param role
     * @return
     */
    ResponseResult addRole(Role role);

    /**
     *  更新角色
     * @param role
     * @return
     */
    ResponseResult updateRole(Role role);

    List<Role> selectRoleAll();

    List<Long> selectRoleIdByUserId(Long userId);
}
