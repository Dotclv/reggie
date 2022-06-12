package com.mingyang.reggie.service.impl;

import com.mingyang.reggie.common.result.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 12:49
 * @version: 1.0
 */
public interface CommonService {
    Result upload(MultipartFile file);

    void download(String filePath, HttpServletResponse response);

}
