package com.lm16.uo.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler({BaseException.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest request, Exception e){
        ErrorInfo errorInfo = new ErrorInfo();

        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setCode(ErrorInfo.SUCCESS);

        return errorInfo;
    }

}
