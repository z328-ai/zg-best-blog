package com.zgbest.zgBlogFront.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zgbest.zgBlogFront.domin.vo.*;
import com.zgbest.zgBlogFront.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@ResponseBody
@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
     @GetMapping
    public ModelAndView BlogController
             (@RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
              @RequestParam(name = "pageSize",defaultValue = "6") int pageSize,
             @RequestParam(name = "likeTitle",defaultValue = "") String likeTitle,
              @RequestParam(name = "articleByType",defaultValue = "") String articleByType){
         ModelAndView modelAndView = new ModelAndView();
         PageVo pageVo = blogService.AllArticle(pageNum, pageSize,likeTitle,articleByType);
         List<ArticleTypeVo> articleTypeVos = blogService.allArticleType();
         List<PopularArticleVo> popularArticleVos = blogService.popularArticle();

         List<TagsVo> tagsVos = blogService.allTags();
         modelAndView.addObject("pageVo",pageVo);
         modelAndView.addObject("articleTypeVos",articleTypeVos);
         modelAndView.addObject("tagsVos",tagsVos);
         modelAndView.addObject("popularArticleVos",popularArticleVos);

         modelAndView.setViewName("blog");
         return modelAndView;
    }

}
