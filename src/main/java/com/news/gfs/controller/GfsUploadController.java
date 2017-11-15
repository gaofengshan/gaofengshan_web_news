package com.news.gfs.controller;
import com.news.gfs.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class GfsUploadController {
    @RequestMapping(value = "/upload.html")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        //获取后缀
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 加上时间戳 然后存为图片名
        String fileName = System.currentTimeMillis() + extName;
        try {
            File newFile = new File("E:/upload/", fileName);
            //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(newFile);
            // 图片压缩
            ImageUtil.imgThumb(newFile, "E:/upload/"+ fileName, 300, 300, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传成功返回原来页面
        return  fileName;
    }
    @RequestMapping(value = "/upload2.html")
    @ResponseBody
    public String fileUploadByBox(@RequestParam("file") MultipartFile file) {
        //获取本名去掉后缀的
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 加上时间戳 然后存为图片名
        String fileName = System.currentTimeMillis() + extName;
        try {
            File newFile = new File("E:/upload/", fileName);
            //通过CommonsMultipartFile的方法直接写文件
            file.transferTo(newFile);
            // 图片压缩
            ImageUtil.imgThumb(newFile, "E:/upload/"+ fileName, 300, 200, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //上传成功返回原来页面
        return "{\"error\":0,\"url\":\"" + "http://localhost:8080/upload/" + fileName + "\"}";
    }
    @RequestMapping("/cut.html")
    @ResponseBody
    public String cutImg(String fileName, int x1, int y1, int w, int h) throws Exception {
        //图片剪裁
        ImageUtil.imgSourceRegion("E:/upload/" + fileName, "E:/upload/" + fileName, x1, y1, w, h, 100, 100, true);
        return fileName;
    }
}

