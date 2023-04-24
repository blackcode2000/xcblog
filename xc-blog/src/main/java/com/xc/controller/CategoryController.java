package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.vo.CategoryVo;
import com.xc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }

//    @GetMapping("/listAllCategory")
//    public ResponseResult listAllCategory(){
//        List<CategoryVo> list = categoryService.listAllCategory();
//        return ResponseResult.okResult(list);
//    }
}
