package com.mingyang.reggie.service;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.service.impl.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 12:50
 * @version: 1.0
 */
@Slf4j
@Service
public class CommonServiceImpl implements CommonService {

    @Value("${upload.filePath}")
    private String filePath;

    @Override
    public Result upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String oldName = filename.substring(0, filename.lastIndexOf("."));
        String replace = UUID.randomUUID().toString().replace("-", "");
        String newName = oldName + "_" + replace + suffix;
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = suffix.substring(suffix.indexOf(".") + 1);
        String path = filePath +format+File.separator+dir;

        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        log.info("文件上传路径：{}",path+File.separator+newName);

        try {
            file.transferTo(Paths.get(path,newName));
        } catch (IOException e) {
            log.error("文件上传失败：{}",e.getMessage());
            e.printStackTrace();
        }
        return Result.success(format+"/"+dir+"/"+newName);
    }

    @Override
    public void download(String path, HttpServletResponse response) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath + path));
            String outFileName = path.substring(path.lastIndexOf(File.separator) + 1);
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;fileName="+ URLEncoder.encode(outFileName,"UTF-8"));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
//            outputStream.write(bytes);
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            log.error("文件下载失败：{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
