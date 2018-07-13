package com.csc.learn.swagger.support;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author LiHuan 2018-7-11 下午3:54:00 <br>
 *         接口返回对象
 */
@ApiModel("接口返回数据")
public final class RestRespBody<T> {
	@ApiModelProperty(value = "默认状态:0表示失败, 1表示成功")
	private String code;
	@ApiModelProperty(value = "请求处理描述")
	private String msg;
	@ApiModelProperty(value = "返回数据集")
	private T data;

	public RestRespBody() {

	}

	public RestRespBody(String code) {
		this.code = code;
	}

	public RestRespBody(String code, String msg) {
		this(code);
		this.msg = msg;
	}

	public RestRespBody(String code, String msg, T data) {
		this(code, msg);
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RestRespBody [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
