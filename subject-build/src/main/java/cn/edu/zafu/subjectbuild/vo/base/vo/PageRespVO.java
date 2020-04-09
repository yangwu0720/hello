package cn.edu.zafu.subjectbuild.vo.base.vo;


import cn.edu.zafu.subjectbuild.vo.base.page.PageVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页返回vo
 * @author cyk
 *
 */
@Setter
@Getter
@ToString
public class PageRespVO<T> extends BaseRespVO {
	/**
	 * 分页返回vo
	 */
	private PageVO<T> pageVO;
}
