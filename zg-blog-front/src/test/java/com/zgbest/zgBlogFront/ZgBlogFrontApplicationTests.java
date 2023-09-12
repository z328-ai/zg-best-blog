package com.zgbest.zgBlogFront;

import com.zgbest.zgBlogFront.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ZgBlogFrontApplicationTests {
    @Autowired
    private EmailService emailService;
    @Test
    void contextLoads() {


    }

}
