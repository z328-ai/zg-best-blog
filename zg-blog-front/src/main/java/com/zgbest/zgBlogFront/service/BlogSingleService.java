package com.zgbest.zgBlogFront.service;

import com.zgbest.zgBlogFront.domin.vo.SingleArticleTagsVo;
import com.zgbest.zgBlogFront.mapper.BlogSingleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogSingleService {
    @Autowired
    private BlogSingleMapper blogSingleMapper;

    public SingleArticleTagsVo SingleArticleTags(Integer id){
        SingleArticleTagsVo singleArticleTagsVo = blogSingleMapper.SingleArticleTags(id);
        return singleArticleTagsVo;
    }
}
