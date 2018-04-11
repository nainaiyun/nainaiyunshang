package com.nainai.user.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by haopeng yan on 2018/1/3 14:25.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. nainai All Rights Received
 */
public class BusinessException extends Exception implements OpsException {

    private static final long serialVersionUID = 5368955536395958600L;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 异常编码
     */
    private String errCode;

    /**
     * 异常信息
     */
    private String errMsg;

    /**
     * 业务异常构造
     *
     * @param moduleName  模块编码
     * @param t           异常源信息
     * @param errCode     异常编码
     * @param errMsgParam 异常消息参数
     */
    public BusinessException(String moduleName, Throwable t, String errCode, String... errMsgParam) {
        this(moduleName, t, true, errCode, errMsgParam);
    }

    /**
     * 业务异常构造
     *
     * @param moduleName   模块编码
     * @param t            异常源信息
     * @param cacheMessage 缓存错误信息标志
     * @param errCode      异常编码
     * @param errMsgParam  异常消息参数
     */
    public BusinessException(String moduleName, Throwable t, boolean cacheMessage, String errCode, String... errMsgParam) {
        super(t);
        String errorMessage = ExceptionConfig.mm(moduleName, cacheMessage, errCode, errMsgParam);
        this.errCode = errCode;
        this.errMsg = errorMessage;
        this.moduleName = moduleName;
    }

    /**
     * 业务异常构造
     *
     * @param moduleName 模块编码
     * @param errCode    异常编码
     */
    public BusinessException(String moduleName, String errCode) {
        this(moduleName, null, errCode, null);
    }

    /**
     * 业务异常构造
     *
     * @param moduleName 模块编码
     * @param t          异常源信息
     * @param errCode    异常编码
     */
    public BusinessException(String moduleName, Throwable t, String errCode) {
        this(moduleName, t, errCode, null);
    }

    /**
     * 业务异常构造
     *
     * @param moduleName  模块编码
     * @param errCode     异常编码
     * @param errMsgParam 异常消息参数
     */
    public BusinessException(String moduleName, String errCode, String... errMsgParam) {
        this(moduleName, null, errCode, errMsgParam);
    }

    @Override
    public String getMessage() {
        return moduleName + "-" + errCode + ":" + errMsg;
    }

    /**
     * 获取堆栈信息
     *
     * @return 堆栈信息
     */
    public final String getBackStacks() {
        if (this.getCause() == null) {
            return "";
        } else {
            return getStackTrace(this.getCause());
        }
    }

    /**
     * 输出异常堆栈信息
     *
     * @param t 异常
     * @return 堆栈信息
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        t.printStackTrace(out);
        return sw.toString();
    }

    @Override
    public String getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrDtlMsg() {
        return this.getMessage();
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
