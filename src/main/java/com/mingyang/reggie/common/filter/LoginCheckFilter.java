package com.mingyang.reggie.common.filter;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.common.utils.JsonTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author: ymy
 * @program: reggie
 * @description: 登录拦截器
 * @date: 2022/6/11 16:56
 * @version: 1.0
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取本次请求的uri
        String requestUri = request.getRequestURI();
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };
        // 判断是否需要拦截
        if(checkUrl(requestUri, urls)) {
            filterChain.doFilter(request, response);
            return;
        }
        // 获取session
        if(request.getSession().getAttribute("employee") != null) {
            long id = Thread.currentThread().getId();
            log.info("线程 {} 获取到session", id);
            filterChain.doFilter(request, response);
            return;
        }
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().write(Objects.requireNonNull(JsonTool.toJson(Result.failure(ResultCode.USER_NOT_LOGIN))));
        log.info("登录拦截器 拦截到请求:{}",request.getRequestURI());

    }

    /**
     * 路径匹配,判断是否需要拦截
     * @param requestUri
     * @param urls
     * @return
     */
    public boolean checkUrl(String requestUri, String[] urls) {
        for (String u : urls) {
            if (PATH_MATCHER.match(u, requestUri)) {
                return true;
            }
        }
        return false;
    }
}
