package com.zgbest.zgBlogFront.mapper;

import com.github.pagehelper.Page;
import com.zgbest.zgBlogFront.domin.entity.Articles;

import java.util.List;

public interface BlogMapper {
    public Page<Articles> allArticles();
}
