package com.zgbest.zgBlogFront.domin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Articles {
    private Integer Id;
    private String title;
    private String articleTypeName;
    private String content;
    private Date created;
    private Date updated;
    private Integer views;
    private Integer comments;
    private String articleImg;
    private Integer userId;
    private Integer articleTypeId;
}
