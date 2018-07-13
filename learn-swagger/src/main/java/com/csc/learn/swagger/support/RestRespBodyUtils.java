package com.csc.learn.swagger.support;

/**
 * @author LiHuan 2018-7-11 下午3:54:00 <br>
 *         接口返回对象工具类
 */
public final class RestRespBodyUtils {

	private static final String success = "1"; // 成功
	private static final String failure = "0"; // 失败

	private RestRespBodyUtils() {

	}

	/**
	 * 请求处理失败时，返回的错误提示
	 * 
	 * @param msg
	 *            错误描述
	 */
	public static <T> RestRespBody<T> failure(String msg) {
		return new RestRespBody<T>(failure, msg);
	}

	/**
	 * 请求处理失败时，返回的错误提示
	 * 
	 * @param msg
	 *            错误描述
	 * @param data
	 *            数据
	 */
	public static <T> RestRespBody<T> failure(String msg, T data) {
		return new RestRespBody<T>(failure, msg, data);
	}

	/**
	 * 请求处理失败时，返回的错误提示
	 * 
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            错误描述
	 */
	public static <T> RestRespBody<T> failure(String code, String msg) {
		return new RestRespBody<T>(code, msg);
	}

	/**
	 * 请求处理失败时，返回的错误提示
	 * 
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            错误描述
	 */
	public static <T> RestRespBody<T> failure(String code, String msg, T data) {
		return new RestRespBody<T>(code, msg, data);
	}

	/**
	 * 请求处理成功
	 */
	public static <T> RestRespBody<T> success() {
		return success("");
	}

	/**
	 * 请求处理成功
	 * 
	 * @param msg
	 *            错误描述
	 */
	public static <T> RestRespBody<T> success(String msg) {
		return new RestRespBody<T>(success, msg);
	}

	/**
	 * 请求处理成功
	 * 
	 * @param msg
	 *            成功描述
	 * @param data
	 *            数据
	 */
	public static <T> RestRespBody<T> success(String msg, T data) {
		return new RestRespBody<T>(success, msg, data);
	}

	/**
	 * 请求处理成功
	 * 
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            成功描述
	 */
	public static <T> RestRespBody<T> success(String code, String msg) {
		return new RestRespBody<T>(code, msg);
	}

	/**
	 * 请求处理成功
	 * 
	 * @param code
	 *            自定义编码
	 * @param msg
	 *            成功描述
	 * @param data
	 *            数据
	 */
	public static <T> RestRespBody<T> success(String code, String msg, T data) {
		return new RestRespBody<T>(code, msg, data);
	}
}
