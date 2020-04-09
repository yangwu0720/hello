package cn.edu.zafu.subjectbuild.frame.common;

/**
 * 公共常量类
 * @author cyk
 * @since 2019-06-06
 */
public class Constant {
	/**
	 * 请求成功状态码 200
	 */
	public static final Integer REQ_SUCCESS_CODE = 200;
	/**
	 * 请求成功信息 请求成功
	 */
	public static final String REQ_SUCCESS_MSG = "请求成功";
	/**
	 * 发生服务器错误 500
	 */
	public static final Integer REQ_SERVER_ERROR_CODE = 500;
	/**
	 * 发生服务器错误 服务器发生错误
	 */
	public static final String REQ_SERVER_ERROR_MSG = "服务器发生错误";
	/**
	 * 参数错误 300
	 */
	public static final Integer REQ_PARAM_ERROR_CODE = 300;
	/**
	 * 参数错误信息
	 */
	public static final String REQ_PARAM_ERROR_MSG = "参数错误";
	/**
	 * session 用户 key
	 */
	public static final String SESSION_USER_KEY = "user";
	/**
	 * session 过期code
	 */
	public static final Integer SESSION_TOMEOUT_CODE = 302;
	/**
	 * session 过期消息
	 */
	public static final String SESSION_TIMEOUT_MSG = "会话已经过期";
	/**
	 * 页面消息 pageMessage
	 */
	public static final String PAGE_MESSAGE = "pageMessage" ;
	/**
	 * 数据更新错误
	 */
	public static final String UPDATE_ERROR = "数据更新错误";
	/**
	 * 数据查询错误
	 */
	public static final String QUERY_ERROR = "数据查询错误";
	/**
	 * 默认时间格式化
	 */
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
}
