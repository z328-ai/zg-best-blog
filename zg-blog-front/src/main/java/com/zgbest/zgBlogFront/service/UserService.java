package com.zgbest.zgBlogFront.service;

import com.zgbest.zgBlogFront.domin.vo.UserVo;
import com.zgbest.zgBlogFront.mapper.BlogSingleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BlogSingleMapper blogSingleMapper;
    public UserVo isAvatar(String name){
        UserVo userVo = blogSingleMapper.selectUser(name);
        return userVo;
    }
}
