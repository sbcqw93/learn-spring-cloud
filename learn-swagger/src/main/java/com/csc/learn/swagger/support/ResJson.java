package com.csc.learn.swagger.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
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
public class ResJson {
	
	private static Logger LOG = LoggerFactory.getLogger(ResJson.class);

	private static final int failure = 1; // 失败
	private static final int success = 0; // 成功

	// 拼接JSON基础格式
	private static String json(int status, String data) {
		StringBuffer bufferJson = new StringBuffer();
		bufferJson.append("{");
		bufferJson.append("\"").append("status").append("\":").append(status)
				.append(",");
		bufferJson.append("\"").append("data").append("\":").append(data);
		bufferJson.append("}");
		return bufferJson.toString();
	}

	/**
	 * 请求处理失败时，返回的JSON对象
	 * 
	 * @param errorCode
	 *            错误明细码
	 * @param errorMsg
	 *            错误描述
	 * @return 失败的JSON格式数据
	 */
	public static String failure(String errorCode, String errorMsg) {
		if (null == errorCode) {
			errorCode = "";
		}
		if (null == errorMsg) {
			errorMsg = "";
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("errorCode", errorCode);
		data.put("errorMsg", errorMsg);
		return json(failure, JSON.toJSONString(data));
	}

	/**
	 * 请求处理成功，返回无返回值的JSON对象
	 * 
	 * @return 成功的JSON格式数据,不需要返回值
	 */
	public static String success() {
		return json(success, "{}");
	}
	
	/**
	 * 请求处理成功，返回有返回值的JSON对象
	 * @param <T>
	 * 
	 * @param data
	 *            当<B>T</B>为String时,不能是JSON格式.
	 * @return 成功的JSON格式数据
	 */
	public static <T> String success(T data) {
		
		if (null == data) {
			LOG.debug("{}##data is null.", "11000100000");
			return success();
		}
		
		try {
			SerializeConfig config = new SerializeConfig();
	    	//config.put(JsonBase64String.class, JsonBase64StringSerializer.instance);
	    	return json(success, JSON.toJSONString(data, config));
		} catch (Exception e) {
			LOG.error("{}##JSON序列化错误{}", new Object[] { "11000101001", e.getMessage() });
			//LOG.error("{}##JSON序列化错误{}", new Object[] { "11000101001", LogUtils.stackTrace(e) });
			return failure("11000101001", "JSON序列化错误");
		}
	}
}
