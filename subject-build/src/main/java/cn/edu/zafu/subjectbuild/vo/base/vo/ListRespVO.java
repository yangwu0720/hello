package cn.edu.zafu.subjectbuild.vo.base.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ListRespVO<T> extends BaseRespVO {
	/**
	 * 返回列表
	 */
	private List<T> list;
}
