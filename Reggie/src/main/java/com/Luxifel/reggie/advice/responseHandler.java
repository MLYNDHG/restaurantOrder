package com.Luxifel.reggie.advice;

import com.Luxifel.reggie.utils.ErrorResult;
import com.Luxifel.reggie.utils.JsonUtil;
import com.Luxifel.reggie.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Slf4j
@ControllerAdvice(basePackages = {"com.Luxifel.reggie.controller"})
public class responseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info(body.toString());
        // 如果是异常结果，直接返回。
        if (body instanceof ErrorResult) {
            return body;
        }
        ResponseResult result = ResponseResult.succeed(body);
        // 字符串与对象转换器不同需要额外判断
//        if (body instanceof String) {
//            return JsonUtil.object2Json(result);
//        }
        return result;
    }
}
