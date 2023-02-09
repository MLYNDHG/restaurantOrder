package com.Luxifel.reggie.advice;

import com.Luxifel.reggie.exception.MyException;
import com.Luxifel.reggie.utils.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理运行时异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //告诉浏览器这是个内部异常。否则浏览器会识别成200正常
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e) {
        ErrorResult error = ErrorResult.fail(e);
        log.error(e.toString());
        e.printStackTrace();
        return error;
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)//请求会响应为200   请求成功   但相应内容为错误信息
    @ExceptionHandler(MyException.class)
    public ErrorResult handleMyException(MyException e) {
        ErrorResult error = ErrorResult.fail(e, e.getMessage());
        e.printStackTrace();
        return error;
    }
}
