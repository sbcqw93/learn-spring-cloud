package com.csc.learn.swagger.support;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LiHuan 2018-7-11 下午3:54:00 <br>
 *         接口返回对象
 */
@ApiModel("接口返回数据")
public class RespBody<T> {
    @ApiModelProperty(value = "状态:1表示失败, 0表示成功")
    private int status;
    @ApiModelProperty(value = "返回数据集")
    private T data;

    private static final int failure = 1; // 失败
    private static final int success = 0; // 成功

    private RespBody() {
    }

    private RespBody(int status) {
        this.status = status;
    }

    private RespBody(int status, T data) {
        this(status);
        this.data = data;
    }

    @ApiModel("自定义返回错误码")
    static class DefaultErrorRespBody {
        @ApiModelProperty(value = "错误码")
        private String errorCode;
        @ApiModelProperty(value = "错误信息")
        private String errorMsg;

        public DefaultErrorRespBody(String errorCode, String errorMsg) {
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    /**
     * @param errorCode 错误明细码
     * @param errorMsg  错误描述
     * @return
     */
    public static RespBody failure(String errorCode, String errorMsg) {
        if (null == errorCode) {
            errorCode = "";
        }
        if (null == errorMsg) {
            errorMsg = "";
        }
        return new RespBody(failure, new DefaultErrorRespBody(errorCode, errorMsg));
    }

    /**
     * 请求处理成功
     *
     * @return
     */
    public static RespBody success() {
        return new RespBody(success, "");
    }

    /**
     * 请求处理成功，
     *
     * @param <T>
     * @param data
     */
    public static <T> RespBody success(T data) {
        return new RespBody(success, data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Reb [status=" + status + ", data=" + data + "]";
    }

}
