package com.zgbest.zgBlogFront.domin.vo;

import com.zgbest.zgBlogFront.domin.entity.Tags;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleArticleTagsVo {
    private Integer Id;
    private String title;
    private String content;
    private List<Tags> tagsList;
}
