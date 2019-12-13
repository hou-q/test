package com.example.demo.common;

import java.util.Map;

/**
 * @Description: 校验异常
 */
public class VerifyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /** 校验错误描述 */
    private StringBuffer errors = new StringBuffer();
    /** 异常编码 */
    private int code = ErrorCodeEm.parameterError.getCode();

    /**
     * 构造校验异常实例
     *
     * @param msg 校验错误描述
     */
    public VerifyException(String msg){
        super("校验参数出现错误：" + msg);
        errors.append("||").append(msg);
    }

    /**
     * 构造校验异常实例
     *
     * @param errorMap 校验错误描述map集合
     */
    public VerifyException(Map<String, String> errorMap){
        super("校验参数出现错误：" + errorMap.toString());
        errorMap.values().forEach(str -> errors.append("||").append(str));
    }

    /**
     * 构造校验异常实例
     *
     * @param msg 校验错误描述
     * @param code 异常编码 {@link ErrorCodeEm}
     */
    public VerifyException(String msg, int code){
        super("校验参数出现错误：" + msg);
        errors.append("||").append(msg);
        this.code = code;
    }

    /**
     * 获取校验错误描述
     */
    public String getErrors() {
        if (errors.length() > 1) {
            return errors.substring(2).toString();
        }
        return "";
    }

    public int getCode() {
        return code;
    }
}
