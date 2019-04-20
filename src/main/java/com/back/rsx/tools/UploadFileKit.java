package com.back.rsx.tools;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadFileKit {

    public String UploadFile(CommonsMultipartFile uploadFile, HttpServletRequest request) {
        // 获取上传的原始文件名
        String fileName = uploadFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("products/logo");
        System.out.println(filePath);
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 重新设置文件名为 UUID，以确保唯一
        fileName = UUID.randomUUID() + fileSuffix;
        file = new File(filePath, fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 写入文件
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
