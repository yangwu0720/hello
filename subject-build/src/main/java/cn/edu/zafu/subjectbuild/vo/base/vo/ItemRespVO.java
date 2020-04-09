package cn.edu.zafu.subjectbuild.vo.base.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回一个对象vo
 * @author cyk
 * @since 2019-06-06
 */

@Setter
@Getter
@ToString
public class ItemRespVO<T> extends BaseRespVO {
	/**
	 * 对象
	 */
	private T item;
}
