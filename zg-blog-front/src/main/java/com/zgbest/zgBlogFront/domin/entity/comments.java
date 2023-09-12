package com.zgbest.zgBlogFront.domin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class comments {
    private Integer id;
    private String content;
    private Date created;
    private Integer userId;
    private Integer articleId;
    private Integer parentCommentId;
}
