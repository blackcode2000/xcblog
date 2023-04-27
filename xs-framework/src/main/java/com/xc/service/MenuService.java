package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.ResponseResult;
import com.xc.domain.dto.MenuDto;
import com.xc.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-04-21 16:34:58
 */
public interface MenuService extends IService<Menu> {
    /**
     * 获取用户权限
     *  管理员返回所有权限
     *  其他用户返回拥有权限
     * @param id
     * @return
     */
    List<String> selectPermsByUserId(Long id);

    /**
     *  根据用户id查询菜单栏
     * @param userId
     * @return
     */
    List<Menu> selectRouterMenuTreeByUserId(Long userId);
    /**
     *  查询菜单
     * @param status 状态
     * @param menuName 菜单名
     * @return
     */
    ResponseResult getMenuList(String status, String menuName);

    /**
     *  添加菜单
     * @param menuDto
     * @return
     */
    ResponseResult addMenu(MenuDto menuDto);

    /**
     *  修改菜单：根据id获取菜单详情
     * @param id
     * @return
     */
    ResponseResult getMenuById(Long id);

    /**
     *  修改菜单： 更新菜单
     * @param menuDto
     * @return
     */
    ResponseResult updateMenu(MenuDto menuDto);


    /**
     *  根据id删除菜单
     * @param id
     * @return
     */
    ResponseResult deleteMenuById(Long id);

    /**
     *  添加角色：获取菜单树
     * @return
     */
    ResponseResult getMenuTree();

    /**
     *  修改角色 获取菜单树
     * @param menu
     * @return
     */
    List<Menu> selectMenuList(Menu menu);

    /**
     *  修改角色 获取角色所关联的菜单权限id列表
     * @param roleId
     * @return
     */
    List<Long> selectMenuListByRoleId(Long roleId);
}
