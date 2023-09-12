package com.zgbest.zgBlogFront.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopularArticleVo {
    private Integer Id;
    private String title;
    private String created;
    private Integer comments;
    private String articleImg;
}
