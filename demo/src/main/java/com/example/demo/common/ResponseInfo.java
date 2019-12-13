package com.example.demo.common;

import com.example.demo.common.jsonSerializer.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 结果响应类
 */
public class ResponseInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 返回状态码 */
    private int code = ErrorCodeEm.REQUEST_SUCCESS.getCode();
    /** 错误信息 */
    private String errorMsg;
    /** 请求是否成功 */
    private boolean success;
    /** 响应数据 */
    private Object data;
    /** 时间戳 */
    @JsonSerialize(using = DateToLongSerializer.class)
    private Date timestamp = new Date();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 成功响应
     *
     * @return 结果响应对象
     */
    public static ResponseInfo success() {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setSuccess(true);
        return responseInfo;
    }

    /**
     * 成功响应
     *
     * @param obj 数据对象
     * @return 结果响应对象
     */
    public static ResponseInfo success(Object obj) {
        ResponseInfo responseInfo = new ResponseInfo();
        if (obj == null) {
            responseInfo.setSuccess(false);
            responseInfo.setCode(ErrorCodeEm.EMPTY_DATA.getCode());
            responseInfo.setErrorMsg(ErrorCodeEm.EMPTY_DATA.getMsg());
        } else {
            responseInfo.setSuccess(true);
            responseInfo.setData(obj);
        }
        return responseInfo;
    }

    /**
     * 失败响应
     *
     * @param errorMsg 失败信息描述
     * @return 结果响应对象
     */
    public static ResponseInfo fail(String errorMsg) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setErrorMsg(errorMsg);
        return responseInfo;
    }

    /**
     * 失败响应
     *
     * @param errorMsg 失败信息描述
     * @param code 失败码
     * @return 结果响应对象
     */
    public static ResponseInfo fail(String errorMsg, int code) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setErrorMsg(errorMsg);
        responseInfo.setCode(code);
        return responseInfo;
    }

    /**
     * 失败响应
     *
     * @param em 失败信息描述
     * @return 结果响应对象
     */
    public static ResponseInfo fail(ErrorCodeEm em) {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setErrorMsg(em.getMsg());
        responseInfo.setCode(em.getCode());
        return responseInfo;
    }
}
