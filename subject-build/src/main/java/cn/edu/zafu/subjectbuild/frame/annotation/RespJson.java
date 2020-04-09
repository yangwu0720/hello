package cn.edu.zafu.subjectbuild.frame.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 标记返回一个json注解
 * @author cyk
 * @since 2019-06-05
 */
@Retention(RUNTIME)
@Target(METHOD)
@ResponseBody
public @interface RespJson {
	/**
	 * 日志 用于日志记录
	 * @return
	 */
	String log() default "";
}
