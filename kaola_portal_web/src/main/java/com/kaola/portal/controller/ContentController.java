package com.kaola.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kaola.content.service.ContentService;
import com.kaola.pojo.TbContent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 广告内容管理
 */
@RestController
@RequestMapping("content")
public class ContentController {
    @Reference
    private ContentService contentService;

    /**
     * 根据类别ID查询广告内容
     * @param categoryId
     * @return
     */
    @RequestMapping("findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId){
        List<TbContent> byCategortId = contentService.findByCategortId(categoryId);
        return byCategortId;
    }
}
