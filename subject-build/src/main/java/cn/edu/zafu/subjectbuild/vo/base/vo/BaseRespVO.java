package cn.edu.zafu.subjectbuild.vo.base.vo;

import lombok.Data;

/**
 * 返回基类
 * @author cyk
 * @since 2019-06-06
 */
@Data
public abstract class BaseRespVO {
	/**
	 * 返回代码
	 */
	private Integer code;
	/**
	 * 返回消息
	 */
	private String message;
}
