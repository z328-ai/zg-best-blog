package com.zgbest.zgBlogFront.service;

import com.github.pagehelper.Page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgbest.zgBlogFront.domin.entity.Articles;
import com.zgbest.zgBlogFront.domin.vo.ArticlesVo;
import com.zgbest.zgBlogFront.domin.vo.PageVo;
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

    public PageVo AllArticle(Integer pageNum, Integer pageSize){
        //查询出pageInfo包含分页插件查出的所有数据
        PageHelper.clearPage();
        PageHelper.startPage(pageNum,pageSize);
        Page<Articles> articles = blogMapper.allArticles();
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
        PageVo pageVo = new PageVo(list, articlesPageInfo.getTotal(), articlesPageInfo.getPages(), pageNum);
        System.out.println(pageVo);
        return pageVo;
    }
}
