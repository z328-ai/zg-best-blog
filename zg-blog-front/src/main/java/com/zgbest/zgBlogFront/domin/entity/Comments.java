package com.zgbest.zgBlogFront.domin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    private Integer id;
    private String content;
    private Date created;
    private Integer userId;
    private Integer articleId;
    private Integer parentCommentId;
}
