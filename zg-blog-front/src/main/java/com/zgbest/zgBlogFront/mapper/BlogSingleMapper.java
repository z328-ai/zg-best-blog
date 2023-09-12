package com.zgbest.zgBlogFront.mapper;

import com.zgbest.zgBlogFront.domin.vo.SingleArticleTagsVo;

public interface BlogSingleMapper {
    SingleArticleTagsVo SingleArticleTags(Integer articleId);
}
