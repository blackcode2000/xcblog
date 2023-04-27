package com.xc.controller;

import com.xc.domain.ResponseResult;
import com.xc.domain.entity.Link;
import com.xc.domain.vo.PageVo;
import com.xc.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/content/link")
public class LinkController {
    @Autowired
    private LinkService linkService;
    /**
     * 分页友链列表
     */
    @GetMapping("/list")
    public ResponseResult list(Link link, Integer pageNum, Integer pageSize)
    {
        PageVo pageVo = linkService.selectLinkPage(link,pageNum,pageSize);
        return ResponseResult.okResult(pageVo);
    }
    @PostMapping
    public ResponseResult add(@RequestBody Link link){
        linkService.save(link);
        return ResponseResult.okResult();
    }
    @GetMapping("{id}")
    public ResponseResult getLinkById(@PathVariable Long id){

        return ResponseResult.okResult(linkService.getById(id));
    }
    @PutMapping
    public ResponseResult edit(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        linkService.removeById(id);
        return ResponseResult.okResult();
    }

    /**
     *  审核
     * @param link
     * @return
     */
    @PutMapping("/changeLinkStatus")
    public ResponseResult changeLinkStatus(@RequestBody Link link){
        linkService.updateById(link);
        return ResponseResult.okResult();
    }
}
