package com.zgbest.zgBlogFront.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zgbest.zgBlogFront.domin.vo.ArticlesVo;
import com.zgbest.zgBlogFront.domin.vo.PageVo;
import com.zgbest.zgBlogFront.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ResponseBody
@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
     @GetMapping
    public ModelAndView BlogController
             (@RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
              @RequestParam(name = "pageSize",defaultValue = "6") int pageSize){
         ModelAndView modelAndView = new ModelAndView();
         PageVo pageVo = blogService.AllArticle(pageNum, pageSize);
         modelAndView.addObject("pageVo",pageVo);
         modelAndView.setViewName("blog");
         return modelAndView;
    }

}
