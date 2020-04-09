package cn.edu.zafu.subjectbuild.vo.base.page;

import java.util.List;

import lombok.Data;

/**
 * 分页返回vo
 * @author cyk
 * @since 2019-06-06
 */
@Data
public class PageVO<T> {
	/**
	 * 总条目数
	 */
	private Long total;
	/**
	 * 当前第几页
	 */
	private Integer page;
	/**
	 * 总页数
	 */
	private Integer pageTotal;
	/**
	 * 每页展示多少条
	 */
	private Integer pageSize;
	/**
	 * 需要展示条目
	 */
	private List<T> items;
}
