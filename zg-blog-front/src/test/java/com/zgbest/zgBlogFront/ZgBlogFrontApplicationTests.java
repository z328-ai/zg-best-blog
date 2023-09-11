package com.zgbest.zgBlogFront;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ZgBlogFrontApplicationTests {

    @Test
    void contextLoads() {
        Date date = new Date();
        System.out.println(date.toString());
    }

}
