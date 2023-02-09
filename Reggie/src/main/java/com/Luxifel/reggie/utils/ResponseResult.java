package com.Luxifel.reggie.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 响应结果包装类
 *
 * @param <T>
 */
@Data
public class ResponseResult<T> {
    /**
     * 1.status状态值：代表本次请求response的状态结果。
     */
    private Integer status;
    /**
     * 2.response描述：对本次状态码的描述。
     */
    private String msg;
    /**
     * 3.data数据：本次返回的数据。
     */
    private T data;
    /**
     * 4.请求路径
     */
    private String requestPath;
    /**
     * 5.code
     */
    private int code;

    /**
     * 成功，创建ResResult：有data数据
     */
    public static ResponseResult succeed(Object data) {
        ResponseResult result = new ResponseResult();
        result.setStatus(HttpStatus.OK.value());
        result.setMsg("success");
        result.setRequestPath(com.Luxifel.reggie.utils.ContextUtil.getRequest().getRequestURI());
        result.setData(data);
        result.setCode(1);
        return result;
    }
    /**
     * 失败，创建ResResult：无data数据
     */
    public static ResponseResult error(String msg) {
        ResponseResult result = new ResponseResult();
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMsg(msg);
        result.setCode(0);
//        result.setRequestPath(com.Luxifel.reggie.utils.ContextUtil.getRequest().getRequestURI());
        return result;
    }
}
