package com.zgbest.zgBlogFront;

import com.zgbest.zgBlogFront.domin.vo.CommentsVo;
import com.zgbest.zgBlogFront.domin.vo.SingleArticleTagsVo;
import com.zgbest.zgBlogFront.mapper.BlogSingleMapper;
import com.zgbest.zgBlogFront.service.BlogSingleService;
import com.zgbest.zgBlogFront.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ZgBlogFrontApplicationTests {
    @Autowired
    private EmailService emailService;
    @Autowired
    protected BlogSingleMapper blogSingleMapper;
    @Test
    void contextLoads() {
        List<CommentsVo> commentsVos = blogSingleMapper.singleArticleComment(0,1);
        System.out.println(commentsVos);
    }

}
