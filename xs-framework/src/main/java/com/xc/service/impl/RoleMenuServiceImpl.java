package com.xc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xc.domain.entity.RoleMenu;
import com.xc.mapper.RoleMenuMapper;
import com.xc.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色和菜单关联表(RoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-02-27 14:51:37
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    /**
     *  根据角色id 删除角色菜单关联表的数据
     * @param id
     */
    @Override
    public void deleteRoleMenuByRoleId(Long id) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId,id);
        remove(queryWrapper);
    }
}
