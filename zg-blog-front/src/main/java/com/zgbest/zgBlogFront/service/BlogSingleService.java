package com.zgbest.zgBlogFront.service;

import com.zgbest.zgBlogFront.domin.vo.CommentsVo;
import com.zgbest.zgBlogFront.domin.vo.SingleArticleTagsVo;
import com.zgbest.zgBlogFront.mapper.BlogSingleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSingleService {
    @Autowired
    private BlogSingleMapper blogSingleMapper;

    public SingleArticleTagsVo SingleArticleTags(Integer id){
        SingleArticleTagsVo singleArticleTagsVo = blogSingleMapper.SingleArticleTags(id);
        return singleArticleTagsVo;
    }

    public CommentsVo authorComment(Integer id){
        CommentsVo commentsVo = blogSingleMapper.authorComment(id);
        return commentsVo;
    }

    public List<CommentsVo> allComment(Integer id){
        List<CommentsVo> commentsVos = blogSingleMapper.singleArticleComment(0, id);
        return commentsVos;
    }
}
