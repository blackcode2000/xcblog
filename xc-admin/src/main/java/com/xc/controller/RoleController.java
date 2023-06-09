package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.dto.RoleDto;
import com.xc.domain.dto.UpdateRoleDto;
import com.xc.domain.entity.Role;
import com.xc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: RoleController
 * @Author zxwyhzy
 * @Date: 2023/2/27 13:08
 * @Version 1.0
 */

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     *  分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param roleDto
     * @return
     */
    @GetMapping("/list")
    public ResponseResult getRoleList(Integer pageNum, Integer pageSize, RoleDto roleDto){
        return roleService.pageRoleList(pageNum,pageSize,roleDto);
    }

    /**
     *  改变角色状态
     * @param updateRoleDto
     * @return
     */

    @PutMapping("/changeStatus")
    public ResponseResult updateStatusById(@RequestBody UpdateRoleDto updateRoleDto){
        return roleService.updateStatusById(updateRoleDto);
    }

    /**
     *  添加角色
     * @param role
     * @return
     */
    @PostMapping
    public ResponseResult addRole(@RequestBody Role role){
        return roleService.addRole(role);

    }
    /**
     * 修改角色：根据角色编号获取详细信息
     */
    @GetMapping(value = "/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId)
    {
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }
    /**
     * 修改角色：更新角色
     */
    @PutMapping
    public ResponseResult edit(@RequestBody Role role)
    {

        return roleService.updateRole(role);
    }

    /**
     *  新增用户：查询所有角色
     * @return
     */
    @GetMapping("/listAllRole")
    public ResponseResult listAllRole(){
        List<Role> roles = roleService.selectRoleAll();
        return ResponseResult.okResult(roles);
    }


    /**
     * 删除角色
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseResult remove(@PathVariable(name = "id") Long id) {
        roleService.removeById(id);
        return ResponseResult.okResult();
    }

}
