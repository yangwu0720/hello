package cn.edu.zafu.subjectbuild.frame.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 日志拦截器
 * @author cyk
 */
@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		System.out.println("1243243242");
		log.debug("<<<<<<<<<<<<<<<<<<<<请求开始>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		log.debug("请求地址：{}",request.getRequestURL());
		log.debug("请求方式：{}",request.getMethod());
		String reqData = JSON.toJSONString(request.getParameterMap()).replace("[", "").replace("]", "");
		log.debug("请求参数：{}",reqData);
		// 获取项目地址
		String path = request.getContextPath();

		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		if(request.getServerPort() == 80){
			basePath = request.getScheme()+"://"+request.getServerName()+path;
		}
		request.setAttribute("base_url", basePath);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.debug("<<<<<<<<<<<<<<<<<<<<请求结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
