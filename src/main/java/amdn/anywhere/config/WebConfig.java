package amdn.anywhere.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import amdn.anywhere.interceptor.CommonInterceptor;
import amdn.anywhere.interceptor.LoginInterceptor;




@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private final CommonInterceptor commonInterceptor;
	private final LoginInterceptor loginInterceptor;


	
	
	public WebConfig(CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
		this.commonInterceptor = commonInterceptor;
		this.loginInterceptor = loginInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/icons/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/error")
				.excludePathPatterns("/favicon.ico");
		
		//로그인 인터셉터
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/survey/**")
				.addPathPatterns("/taster/**")
				.addPathPatterns("/event/**")
				.addPathPatterns("/admin")
				
				
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/icons/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/error")
				.excludePathPatterns("/favicon.ico")
				.excludePathPatterns("/event/eventList")
				.excludePathPatterns("/taster/recruitNotice");
		
		//WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
