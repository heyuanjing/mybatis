package com.mybatis.aop;

public class MonkeyException extends Exception {

    /**  */
    private static final long serialVersionUID = 1L;

    private String            message;

    public MonkeyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
