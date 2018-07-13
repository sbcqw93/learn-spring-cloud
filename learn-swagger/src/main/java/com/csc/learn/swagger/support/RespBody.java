package com.csc.learn.swagger.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * @author LiHuan 2016-1-26 下午5:00:35 <br>
 *         Java提供给PHP、前端、移动端 返回JSON对象的帮助类 <br>
 *         ResJson是ResponseJson的简写
 *
 *         <pre>
 * JSON基础格式为：
 * {
 *   "status":0|1,
 *   "data":{
 *     // 动态属性
 *   }
 * }
 * </pre>
 */
public class RespBody {

	private static final String success = "1"; // 成功
	private static final String failure = "0"; // 失败

	private static SerializerFeature[] features = { SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty };


	private static ValueFilter filter = new ValueFilter() {
		@Override
		public Object process(Object obj, String s, Object v) {
			if(v==null)
				return "";
			return v;
		}
	};


	// 拼接JSON基础格式
	private static <T> String json(String code, String msg, T data) {

		StringBuffer bufferJson = new StringBuffer();
		bufferJson.append("{");
		bufferJson.append("\"").append("code").append("\":\"").append(code).append("\",");
		bufferJson.append("\"").append("msg").append("\":");
		if (null == msg || "".equals(msg)) {
			bufferJson.append("\"\"");
		} else {
			bufferJson.append("\"").append(msg).append("\"");
		}
		bufferJson.append(",\"").append("data").append("\":");
		if (null == data) {
			bufferJson.append("\"\"");
		} else {
			bufferJson.append(JSON.toJSONString(data, filter,features));
		}
		bufferJson.append("}");
		return bufferJson.toString();
	}



	/**
	 * 请求处理失败时，返回的JSON对象
	 *
	 * @param msg
	 *            错误描述
	 * @return 失败的JSON格式数据
	 */
	public static String failure(String msg) {
		return json(failure, msg, null);
	}

	/**
	 * 请求处理失败时，返回的JSON对象
	 *
	 * @param msg
	 *            错误描述
	 * @param data
	 *            数据
	 * @return 失败的JSON格式数据
	 */
	public static <T> String failure(String msg, T data) {
		if (null == data)
			return failure(msg);
		return json(failure, msg, data);
	}

	/**
	 * 请求处理失败时，返回的JSON对象
	 *
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            错误描述
	 * @return 失败的JSON格式数据
	 */
	public static String failure(String code, String msg) {
		return json(code, msg, null);
	}

	/**
	 * 请求处理失败时，返回的JSON对象
	 *
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            错误描述
	 * @param data
	 *            数据
	 * @return 失败的JSON格式数据
	 */
	public static <T> String failure(String code, String msg, T data) {
		if (null == data)
			return failure(code, msg);
		return json(code, msg, data);
	}

	/**
	 * 请求处理成功，返回无返回值的JSON对象
	 *
	 * @param msg
	 *            成功描述
	 * @return
	 */
	public static String success(String msg) {
		return json(success, msg, null);
	}

	/**
	 * 请求处理成功，返回有返回值的JSON对象
	 *
	 * @param msg
	 *            成功描述
	 * @param data
	 *            数据
	 * @return 成功的JSON格式数据
	 */
	public static <T> String success(String msg, T data) {
		if (null == data)
			return success(msg);
		return json(success, msg, data);
	}

	/**
	 * 请求处理成功，返回无返回值的JSON对象
	 *
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            成功描述
	 * @return
	 */
	public static String success(String code, String msg) {
		return json(code, msg, null);
	}

	/**
	 * 请求处理成功，返回有返回值的JSON对象
	 *
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            成功描述
	 * @param data
	 *            数据
	 * @return 成功的JSON格式数据
	 */
	public static <T> String success(String code, String msg, T data) {
		if (null == data)
			return success(code, msg);
		return json(code, msg, data);
	}
}
