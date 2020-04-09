package cn.edu.zafu.subjectbuild.frame.aspect;

import cn.edu.zafu.subjectbuild.vo.base.vo.BaseRespVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 对于方法json执行结果的拦截
 * @author cyk
 *
 */

@Slf4j
@Aspect
@Component
public class RespJsonAspect {
	
		
	@Pointcut("execution(public * cn.edu.zafu.subjectbuild.*.controller.**(..)) && @annotation(cn.edu.zafu.subjectbuild.frame.annotation.RespPage)")
	public void addAspect() {
	}
	
	
	@AfterReturning(value="addAspect()",returning = "res")
	public void methodAfterAdvice(JoinPoint jp,Object res) {
		if (res instanceof BaseRespVO) {
			log.debug("返回json数据："+JSON.toJSONString(res));
		}
	}
	
}
