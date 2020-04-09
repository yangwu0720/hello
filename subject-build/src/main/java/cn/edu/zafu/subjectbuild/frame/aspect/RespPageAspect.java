package cn.edu.zafu.subjectbuild.frame.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
* 对于方法page执行结果的拦截
* @author cyk
* @since 2019-06-06
*/
@Slf4j
@Aspect
@Component
public class RespPageAspect {
	//com.huxiweishi.controller.login.LoginController
		
	@Pointcut("execution(public * cn.edu.zafu.subjectbuild.*.controller.**(..)) && @annotation(cn.edu.zafu.subjectbuild.frame.annotation.RespPage)")
	public void addAspect() {
	}
	
	
	@AfterReturning(value="addAspect()",returning = "res")
	public void methodAfterAdvice(JoinPoint jp,Object res) {
		if (res instanceof ModelAndView) {
			ModelAndView mv = (ModelAndView) res;
			log.debug("返回视图：{}",mv.getViewName()+".html");
			log.debug("视图携带数据：{}",JSON.toJSONString(mv.getModel()));
		}
	}
	
}
