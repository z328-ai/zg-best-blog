package com.zgbest.zgBlogFront.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zgbest.zgBlogFront.domin.vo.*;
import com.zgbest.zgBlogFront.service.BlogService;
import com.zgbest.zgBlogFront.service.BlogSingleService;
import com.zgbest.zgBlogFront.service.EmailService;
import com.zgbest.zgBlogFront.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BlogSingleService blogSingleService;
    @Autowired
    private UserService userService;
     @GetMapping
    public ModelAndView BlogController
             (@RequestParam(name = "pageNum",defaultValue = "1") int pageNum,
              @RequestParam(name = "pageSize",defaultValue = "6") int pageSize,
             @RequestParam(name = "likeTitle",defaultValue = "") String likeTitle,
              @RequestParam(name = "articleByType",defaultValue = "") String articleByType,
              @RequestParam(name = "email",defaultValue = "") String email){
         ModelAndView modelAndView = new ModelAndView();
         PageVo pageVo = blogService.AllArticle(pageNum, pageSize,likeTitle,articleByType);
         List<ArticleTypeVo> articleTypeVos = blogService.allArticleType();
         List<PopularArticleVo> popularArticleVos = blogService.popularArticle();
         List<TagsVo> tagsVos = blogService.allTags();
         if(!email.isEmpty()){
             emailService.sendEmail(email);
         }
         modelAndView.addObject("pageVo",pageVo);
         modelAndView.addObject("articleTypeVos",articleTypeVos);
         modelAndView.addObject("tagsVos",tagsVos);
         modelAndView.addObject("popularArticleVos",popularArticleVos);
         modelAndView.addObject("emailMessage", EmailService.emailMessage);
         modelAndView.setViewName("blog");
         return modelAndView;
    }
    @GetMapping("/single/{id}")
    public ModelAndView BlogSingleController(@PathVariable("id") Integer id){
        SingleArticleTagsVo singleArticleTagsVo = blogSingleService.SingleArticleTags(id);
        CommentsVo authorCommentsVo = blogSingleService.authorComment(id);
        List<CommentsVo> commentsVos = blogSingleService.allComment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("singleArticleTagsVo",singleArticleTagsVo);
        modelAndView.addObject("authorComment",authorCommentsVo);
        modelAndView.addObject("commentVos",commentsVos);
        System.out.println(authorCommentsVo);
        modelAndView.setViewName("single");
        return modelAndView;
    }

    @GetMapping("/user/isAvatar")
    @ResponseBody
    public UserVo isAvatar(String name){
        UserVo avatar = userService.isAvatar(name);
        return avatar;
    }
    @PostMapping("/comment/submit/{articleId}")
    @ResponseBody
    public String insertUserAndComment(@PathVariable("articleId") Integer articleId,
                                       @RequestParam("message") String message,
                                       @RequestParam("inputAvatar") MultipartFile multipartFile,
                                       @RequestParam("inputName") String  inputName){
        System.out.println(articleId);
        System.out.println(message);
        System.out.println(multipartFile.getOriginalFilename());
         return "搜索";
    }
}
