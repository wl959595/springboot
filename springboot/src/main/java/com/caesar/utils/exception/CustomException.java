package com.caesar.utils.exception;

/**
 * @Author CaesarWang
 * @ClassName CustomException
 * @Description 自定义异常，校验用户输入的合法性
 * @Date 2020/12/24 17:03
 * @Version 1.0
 **/
public class CustomException extends RuntimeException {

    private String exceptionMsg;

    public CustomException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
