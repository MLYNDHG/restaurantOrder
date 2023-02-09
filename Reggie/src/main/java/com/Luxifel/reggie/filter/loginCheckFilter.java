package com.Luxifel.reggie.filter;

import com.Luxifel.reggie.utils.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.jar.JarEntry;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class loginCheckFilter implements Filter {
    public  static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String reqUrl = httpServletRequest.getRequestURI();
//        log.info("拦截到请求路径:{}",reqUrl);
        //不需处理的请求路径
        String [] releaseUrls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/swagger-ui.html",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/v2/**"
        };
        String requestUrl = httpServletRequest.getRequestURI();
        Boolean check = check(releaseUrls, requestUrl);
        if (check){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        if(httpServletRequest.getSession().getAttribute("employee") != null){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        ResponseResult data = new ResponseResult().error("NOTLOGIN");
        data.setRequestPath(reqUrl);
        httpServletResponse.getWriter().write(JSON.toJSONString(data));
        return;
    }

    /**
     * 请求路径  检查是否可通过
     * @param urls
     * @param requestUrl
     * @return
     */
    public Boolean check(String[] urls,String requestUrl){
        Boolean match = false;
        for (String url : urls) {
            match = PATH_MATCHER.match(url,requestUrl);
            if(match == true) {
                return true;
            }
        }
        return false;
    }
}
