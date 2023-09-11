package com.zgbest.zgBlogFront.service;

import com.github.pagehelper.Page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgbest.zgBlogFront.domin.entity.Articles;
import com.zgbest.zgBlogFront.domin.vo.*;
import com.zgbest.zgBlogFront.mapper.BlogMapper;
import com.zgbest.zgBlogFront.util.DateFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public PageVo AllArticle(Integer pageNum, Integer pageSize,String title,String articleByType){
        //查询出pageInfo包含分页插件查出的所有数据
        PageHelper.clearPage();
        Page<Articles> articles = null;
        if(title.isEmpty() || articleByType.isEmpty()){
            PageHelper.startPage(pageNum,pageSize);
            articles = blogMapper.allArticles(title,articleByType);
        }
        if(!title.isEmpty()){
            PageHelper.startPage(pageNum,pageSize);
            articleByType="";
            articles = blogMapper.allArticles('%'+ title + '%',articleByType);
        }
        if(!articleByType.isEmpty()){
            PageHelper.startPage(pageNum,pageSize);
            title="";
            articles = blogMapper.allArticles(title,articleByType);
        }
        PageInfo<Articles> articlesPageInfo = new PageInfo<>(articles);

//        拿出list进行Article的date数据格式化
        List<Articles> articlesPageInfoList = articlesPageInfo.getList();
        List<ArticlesVo> list =  articlesPageInfoList.stream().map(n->{
            ArticlesVo articlesVo = new ArticlesVo();
            BeanUtils.copyProperties(n,articlesVo);
            articlesVo.setCreated(DateFormat.simpleDateFormat(n.getCreated()));
            return articlesVo;
        }).collect(Collectors.toList());
//      开始封装pageVo
        PageVo pageVo = new PageVo(list, title,articlesPageInfo.getTotal(), articlesPageInfo.getPages(), pageNum,articleByType);
        System.out.println(pageVo);
        return pageVo;
    }

    public List<ArticleTypeVo> allArticleType(){
        List<ArticleTypeVo> articleTypeVos = blogMapper.allArticleType();
        return articleTypeVos;
    }

    public List<TagsVo> allTags(){
        List<TagsVo> tagsVos = blogMapper.allTagsVo();
        return tagsVos;
    }

    public List<PopularArticleVo> popularArticle(){
        List<PopularArticleVo> popularArticleVos = blogMapper.popularArticle();
        return popularArticleVos;
    }
//    public ArticleTimeNumVo articleTimeNum(){
//        ArticleTimeNumVo articleTimeNumVo = new ArticleTimeNumVo();
//        int month = 9;
//        String startTime = "";
//        String endTime = "";
//        for (int i = 0; i < 5; i++) {
//            if(month+1==12)
//            startTime = "2023-0"+month+"-01";
//            endTime = "2023-0"+(month+1)+"-01";
//            Integer integer = blogMapper.articleTimeNum(startTime, endTime);
//            articleTimeNumVo.nums.add(integer);
//        }
//        return articleTimeNumVo;
//    }
}
