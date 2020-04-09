package cn.edu.zafu.subjectbuild.vo.base.vo;

import lombok.Data;

/**
 * 分页请求vo
 * @author cyk
 * @since 2019-06-06
 */

@Data
public class PageReqVO {
	/**
	 * 当前第几页
	 */
	private Integer page;
	/**
	 * 每页展示多少条
	 */
	private Integer pageSize;
}
