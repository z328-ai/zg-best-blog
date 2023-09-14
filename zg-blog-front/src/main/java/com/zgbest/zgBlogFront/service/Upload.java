package com.zgbest.zgBlogFront.service;


import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public class Upload {

   private static String accessKey = "pr8-uhyODx8tFPVPbQxf0644VBNAh3UYXhsLzvGB";      //公钥
    private static String accessSecretKey = "6yaNpLVTkdbIhnRsl3zh5PnGxnyvid5Zq3RqW5Ln";   //私钥
    private static String bucket = "zg-best-blog";   // 存储空间
   private static String url = "s0iau1vaj.hd-bkt.clouddn.com";

   public static String uploadPhoto( MultipartFile file){
       Configuration configuration = new Configuration();
       Auth auth = Auth.create(accessKey, accessSecretKey);
       String upToken = auth.uploadToken(bucket);
       UploadManager uploadManager = new UploadManager(configuration);
       Response response = null;
       DefaultPutRet putRet = null;
       try {
           response = uploadManager.put(file.getBytes(),file.getOriginalFilename(),upToken);
           putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

        return  "http://"+url+"/"+file.getOriginalFilename();
   }
}
