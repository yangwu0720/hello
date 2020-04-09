package cn.edu.zafu.subjectbuild.frame.config;

import java.io.File;

import javax.annotation.Resource;

import cn.edu.zafu.subjectbuild.frame.interceptor.LoggingInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;


/**
 * mvc相关配置
 * @author cyk
 * @since 2019-06-06
 */

@Configuration
public class MvcHandlerConfig implements WebMvcConfigurer , ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	@Resource
	private ThymeleafProperties thymeleafProperties;
	
	@Autowired
	private LoggingInterceptor loggingInterceptor;

	
	@Bean
	public SpringResourceTemplateResolver defaultTemplateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(this.applicationContext);

		String prefix = thymeleafProperties.getPrefix();
		if(prefix.contains("{user.dir}")) {
			String rootPath = System.getProperty("user.dir").replaceAll("\\\\", "/");
			prefix = prefix.replaceAll("\\{user.dir\\}", rootPath);
		}

		resolver.setPrefix(prefix);

		resolver.setSuffix(this.thymeleafProperties.getSuffix());
		resolver.setTemplateMode(this.thymeleafProperties.getMode());
		if (this.thymeleafProperties.getEncoding() != null) {
			resolver.setCharacterEncoding(this.thymeleafProperties.getEncoding().name());
		}
		resolver.setCacheable(this.thymeleafProperties.isCache());
		Integer order = this.thymeleafProperties.getTemplateResolverOrder();
		if (order != null) {
			resolver.setOrder(order);
		}

		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/**/
		String localPath = System.getProperty("user.dir") + File.separator + "web" + File.separator + "static"
				+ File.separator;
		File localDir = new File(localPath);
		if (localDir.exists() && localDir.isDirectory()) {
			registry.addResourceHandler("/static/**").addResourceLocations("file:" + localPath);
		}

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Bean  
    public LocaleResolver localeResolver() {  
		SessionLocaleResolver sl = new SessionLocaleResolver();
		return sl;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggingInterceptor).excludePathPatterns("/static/**","/global/uploadFileBase64/**").addPathPatterns("/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
