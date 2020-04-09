package cn.edu.zafu.subjectbuild.frame.config;

import java.util.List;

import cn.edu.zafu.subjectbuild.frame.common.Constant;
import cn.edu.zafu.subjectbuild.frame.exception.CustomException;
import cn.edu.zafu.subjectbuild.vo.base.vo.RespVO;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 错误处理器
 * @author cyk
 * @since 2019-06-06
 */
@Slf4j
@ControllerAdvice
public class ExceptionControllerHandler {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public RespVO javaExceptionHandler(Exception e) {
		e.printStackTrace();
		log.error("服务器发生错误{}", e.getMessage() );
		RespVO respVO = new RespVO();
		respVO.setCode(Constant.REQ_SERVER_ERROR_CODE);
		respVO.setMessage(Constant.REQ_SERVER_ERROR_MSG);
		log.error("返回json数据：{} " , JSON.toJSONString(respVO, true));
		return respVO;
	}
	
	@ExceptionHandler(value= CustomException.class)
	@ResponseBody
	public RespVO CustomExceptionHandler(CustomException e) {
		log.error("程序自定义异常：{}", e.getMessage() );
		e.printStackTrace();
		RespVO respVO = new RespVO();
		respVO.setCode(Constant.REQ_PARAM_ERROR_CODE);
		respVO.setMessage(e.getMessage());
		log.error("返回json数据：{}",JSON.toJSONString(respVO));
		return respVO;
	}
	
	@ExceptionHandler(value=BindException.class)
	@ResponseBody
	public RespVO bindExceptionHandler(BindException e) {
		log.error("参数错误");
		e.printStackTrace();
		BindingResult bindingResult = e.getBindingResult();
		List<ObjectError> list = bindingResult.getAllErrors();
		RespVO respVO = new RespVO();
		respVO.setCode(Constant.REQ_PARAM_ERROR_CODE);
		if (list == null || list.size() == 0) {
			respVO.setMessage(Constant.REQ_PARAM_ERROR_MSG);
		} else {
			respVO.setMessage(list.get(0).getDefaultMessage());
		}
		log.error("返回json数据：{}",JSON.toJSONString(respVO));
		return respVO;
	}
}
