package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.service.impl.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 11:36
 * @version: 1.0
 */
@Api(value = "公共接口", tags = "公共接口")
@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private CommonService commonService;

    /**
     * 文件上传
     * @return
     */
    @ApiOperation(value = "文件上传", notes = "文件上传")
    @ApiImplicitParam(name = "file",value = "单文件上传",required = true,dataType="MultipartFile",
            allowMultiple = true,paramType = "form")
    @PostMapping("/upload")
    public Result upload(@RequestPart("file") MultipartFile file) {
        return commonService.upload(file);
    }

    /**
     * 文件下载
     * @param  name 文件名
     * @return 文件下载路径
     */
    @ApiOperation(value = "文件下载", notes = "文件下载")
    @ApiImplicitParam(name = "name",value = "文件名",required = true,dataType="String",
            allowMultiple = false,paramType = "path")
    @GetMapping("/download")
    public void download(@RequestParam("name") String name, HttpServletResponse response) {
        commonService.download(name,response);
    }

}
