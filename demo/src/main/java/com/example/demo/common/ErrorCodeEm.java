package com.example.demo.common;

/**
 * @Description: 服务状态码枚举类
 */
public enum ErrorCodeEm {
    /** 系统繁忙 */
    SYSTEM_BUSY(-1, "系统繁忙,请稍后再试"),
    /** 空数据 */
    EMPTY_DATA(-2, "空数据"),
    /** 请求成功 */
    REQUEST_SUCCESS(0, "请求成功"),
    /** 未登录 */
    NOT_LOGIN(1000, "未登录"),
    /** 无权限 */
    NO_PERMISSION(1001, "无权限"),
    /** 帐户或密码错误 */
    ACCOUNT_PASSWORD_ERROR(1002, "帐户或密码错误"),
    /** 请求方式错误 */
    REQUEST_METHOD_ERROR(4000, "请求方式错误"),
    /** 未找到 */
    NOT_FOUND(4001, "未找到"),
    /** 文件上传错误 */
    fileUploadError(4002, "文件上传错误"),
    /** 文件读取出错 */
    FILE_READING_ERROR(4003, "文件读取出错"),
    /** 参数错误 */
    parameterError(5000, "参数错误"),
    /** 导入数据失败 */
    IMPORT_DATA_ERROR(5001, "导入数据失败"),
    /** 导出数据失败 */
    EXPORT_DATA_ERROR(5002, "导出数据失败"),
    /** 业务处理错误 */
    HANDLE_ERROR(5003, "业务处理错误");

    /** 编码 */
    private int code;
    /** 信息 */
    private String msg;

    ErrorCodeEm(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据代码编号获取枚举实例
     *
     * @param code 代码编号
     */
    public static ErrorCodeEm fromCode(int code) {
        for (ErrorCodeEm errorCode : ErrorCodeEm.values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return getMsg() + "|" + this.name();
    }
}
