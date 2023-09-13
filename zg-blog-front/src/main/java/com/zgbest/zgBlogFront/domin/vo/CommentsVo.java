package com.zgbest.zgBlogFront.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsVo {
    private Integer id;
    private Integer articleId;
    private String name;
    private String content;
    private String created;
    private String avatar;
    private Integer parentCommentId;
    private List<CommentsVo> commentsVoList;
}
