package com.zgbest.zgBlogFront.domin.vo;

import lombok.Data;

@Data
public class ArticlesVo {
    private Integer Id;
    private String title;
    private String articleTypeName;
    private String content;
    private String created;
    private Integer views;
    private Integer comments;
    private String articleImg;


}
