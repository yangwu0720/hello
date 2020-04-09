package cn.edu.zafu.subjectbuild.frame.base.controller;


import cn.edu.zafu.subjectbuild.frame.common.Constant;
import cn.edu.zafu.subjectbuild.frame.exception.CustomException;
import cn.edu.zafu.subjectbuild.vo.base.vo.BaseRespVO;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;

/**
 * controller基类
 * @author cyk
 * @since 2019-06-06
 */

@Slf4j
public abstract class BaseController {
	
	/**
	 * 错误处理器
	 * @param respVO
	 * @param e
	 * @return
	 */
	public BaseRespVO handleException(BaseRespVO respVO, Exception e) {
		e.printStackTrace();
		log.error("系统发生错误{}" , e.getMessage());
		respVO.setCode(Constant.REQ_SERVER_ERROR_CODE);
		if (e instanceof CustomException) {
			respVO.setMessage(e.getMessage());
		} else {
			respVO.setMessage(Constant.REQ_SERVER_ERROR_MSG); 
		}
		return respVO;
	}
	
	/**
	 * session不存在处理器
	 * @param respVO
	 * @param
	 * @return
	 */
	public BaseRespVO handleSessionTimeout(BaseRespVO respVO) {
		log.error("session不存在，或者已经过期");
		respVO.setCode(Constant.SESSION_TOMEOUT_CODE);
		respVO.setMessage(Constant.SESSION_TIMEOUT_MSG);
		return respVO;
	}
	
	/**
	 * 参数错误
	 * @param respVO
	 * @param msg
	 * @return
	 */
	public BaseRespVO handleParamError(BaseRespVO respVO,String msg) {
		log.error("参数错误: {} ", msg);
		respVO.setCode(Constant.REQ_PARAM_ERROR_CODE);
		if (msg == null) {
			respVO.setMessage(Constant.REQ_PARAM_ERROR_MSG);
		}else {
			respVO.setMessage(msg);
		}
		return respVO;
	}
	
	/**
	 * 参数错误
	 * @param respVO
	 * @return
	 */
	public BaseRespVO handleParamError(BaseRespVO respVO) {
		return handleParamError(respVO, null);
	}
	
	/**
	 * 请求成功处理器
	 * @param respVO
	 * @return
	 */
	public BaseRespVO handleSuccess(BaseRespVO respVO) {
		respVO.setCode(Constant.REQ_SUCCESS_CODE);
		respVO.setMessage(Constant.REQ_SUCCESS_MSG);
		return respVO;
	}
	
	/**
	 * 错误页面处理
	 * @param mv
	 * @param e
	 * @return
	 */
	public ModelAndView handleErrorPage(ModelAndView mv,Exception e) {
		e.printStackTrace();
		log.error("服务器跳转页面错误:{}" ,e.getMessage() );
		mv.setViewName("500");
		if (e instanceof CustomException ) {
			mv.addObject(Constant.PAGE_MESSAGE, e.getMessage());
		} else {
			mv.addObject(Constant.PAGE_MESSAGE,Constant.REQ_SERVER_ERROR_MSG );
		}
		return mv;
	}
	
	public ModelAndView handleErrorPage(ModelAndView mv,Exception e,String page) {
		log.error("服务器自定义跳转页面错误: {} " , e.getMessage());
		mv.setViewName(page);
		if (e instanceof CustomException) {
			mv.addObject(Constant.PAGE_MESSAGE, e.getMessage());
		} else {
			mv.addObject(Constant.PAGE_MESSAGE , Constant.REQ_SERVER_ERROR_MSG);
		}
		return mv;
	}
	
	/**
	 * 页面未找到
	 * @param mv
	 * @return
	 */
	public ModelAndView handleNotFound(ModelAndView mv) {
		log.error("未找到页面:");
		mv.setViewName("404");
		mv.addObject(Constant.PAGE_MESSAGE, "页面未找到");
		return mv;
	}
}
