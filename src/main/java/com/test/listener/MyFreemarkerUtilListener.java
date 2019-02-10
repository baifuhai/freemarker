package com.test.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.test.util.MyFreemarkerUtil;

public class MyFreemarkerUtilListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		
		String basePackagePath = servletContext.getInitParameter("basePackagePath");
		
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		
		MyFreemarkerUtil myFreemarkerUtil = applicationContext.getBean(MyFreemarkerUtil.class);
		myFreemarkerUtil.init(servletContext, basePackagePath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
