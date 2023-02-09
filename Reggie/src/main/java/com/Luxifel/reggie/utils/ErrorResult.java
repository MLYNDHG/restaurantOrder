package com.Luxifel.reggie.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResult {
    /**
     * 异常状态码
     */
    private Integer status;

    /**
     * 用户看得见的异常，例如 用户名重复！！,
     */
    private String msg;

    /**
     * 失败
     */
    private int code;

//    /**
//     * 异常的名字
//     */
//    private String exception;

//    /**
//     * 异常堆栈信息
//     */
//    private String errors;

//    /**
//     * 请求路径
//     */
//    private String requestPath;

    public static ErrorResult fail(Throwable e) {
        return ErrorResult.fail(e, e.getMessage());
    }

    public static ErrorResult fail(Throwable e, String message) {
        ErrorResult result = new ErrorResult();
        result.setMsg(message);
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setCode(0);
//        这三个暂时去掉   不需要看这些信息  只需要成功失败以及对应的信息即可
//        result.setException(e.getClass().getName());
//        result.setErrors(e.toString());
//        result.setRequestPath(ContextUtil.getRequest().getRequestURI());
        return result;
    }
}
