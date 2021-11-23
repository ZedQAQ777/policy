package com.zwj.util;



public enum ResultCode implements IErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(401, "参数检验失败"),
    NOT_FOUND(404, "找不到资源"),
    NOT_MATCH(403, "请求数据格式不符");

    private final long code;
    private final String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

