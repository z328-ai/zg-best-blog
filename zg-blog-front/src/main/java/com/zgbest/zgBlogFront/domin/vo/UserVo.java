package com.zgbest.zgBlogFront.domin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private int id;
    private int articleId;
    private String name;
    private String url;
    private String message;
    private String avatar;

}
