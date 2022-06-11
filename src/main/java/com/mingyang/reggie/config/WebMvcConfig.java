package com.mingyang.reggie.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mingyang.reggie.common.model.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 22:04
 * @version: 1.0
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始静态资源映射");
        registry.addResourceHandler("/backend/**")
                .addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**")
                .addResourceLocations("classpath:/front/");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        /** 配置knife4j 显示文档 */
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        /**
         * 配置swagger-ui显示文档
         */
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        /** 公共部分内容 */
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        // 设置消息转换器的转换规则
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        // 将消息转换器添加到转换器列表中
        converters.add(0,messageConverter);
    }
}
