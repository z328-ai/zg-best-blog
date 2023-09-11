package com.zgbest.zgBlogFront.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageVo {
    private List<ArticlesVo> list;
    private Long total;
    private Integer pages;
    private Integer currentPage;
}
