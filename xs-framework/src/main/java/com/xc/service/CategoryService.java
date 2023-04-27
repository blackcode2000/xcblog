package com.xc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xc.domain.ResponseResult;
import com.xc.domain.entity.Category;
import com.xc.domain.vo.CategoryVo;
import com.xc.domain.vo.PageVo;

import java.util.List;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-03-21 16:54:35
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

    List<CategoryVo> listAllCategory();
    PageVo selectCategoryPage(Category category, Integer pageNum, Integer pageSize);
}
