package com.zgbest.zgBlogFront.mapper;

import com.github.pagehelper.Page;
import com.zgbest.zgBlogFront.domin.entity.Articles;
import com.zgbest.zgBlogFront.domin.vo.*;

import java.util.List;

public interface BlogMapper {
    //查出搜類型對應的文章
    public Page<Articles> allArticles(String title);

    //查出所有類型對應有多少文章
    public List<ArticleTypeVo> allArticleType();

    //查询所有标签
    public List<TagsVo> allTagsVo();

    //查询前三篇最受欢迎的文章
    public List<PopularArticleVo> popularArticle();

//    public Integer articleTimeNum(String startTime,String endTIme);
}
