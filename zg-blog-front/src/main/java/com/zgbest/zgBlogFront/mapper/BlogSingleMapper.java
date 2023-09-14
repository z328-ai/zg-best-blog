package com.zgbest.zgBlogFront.mapper;

import com.zgbest.zgBlogFront.domin.vo.CommentsVo;
import com.zgbest.zgBlogFront.domin.vo.SingleArticleTagsVo;
import com.zgbest.zgBlogFront.domin.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSingleMapper {
    SingleArticleTagsVo SingleArticleTags(Integer articleId);

    CommentsVo authorComment(Integer id);

    List<CommentsVo> singleArticleComment(@Param("id") Integer id,@Param("articleId") Integer articleId);

    UserVo selectUser(String name);
}
