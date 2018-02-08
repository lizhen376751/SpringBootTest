package com.lizhen.sbtest.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhen on 2018/2/6.
 * ControllerAdvice 注解 全局捕获异常的类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> result() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("errorcode", "500");
        result.put("errorMsg", "系统错误！");
        return result;
    }
}
