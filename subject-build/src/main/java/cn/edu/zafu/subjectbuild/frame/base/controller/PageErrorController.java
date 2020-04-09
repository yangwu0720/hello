package com.bsg.frame.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * 页面错误路由
 * @author cyk
 * @since 2019-06-06
 */
@Slf4j
@Controller
public class PageErrorController implements ErrorController {
	
	@RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        log.error("页面发生错误：错误状态码 {}",statusCode);
        log.error("页面错误地址：{}", request.getRequestURL());
        if(statusCode == 401){
            return "401";
        }else if(statusCode == 404){
            return "404";
        }else if(statusCode == 403){
            return "403";
        }else{
            return "500";
        }

    }


	@Override
	public String getErrorPath() {
		return "/error";
	}
}
