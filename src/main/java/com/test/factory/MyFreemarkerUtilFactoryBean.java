package com.test.factory;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.test.util.MyFreemarkerUtil;

public class MyFreemarkerUtilFactoryBean implements FactoryBean<MyFreemarkerUtil>, InitializingBean, ServletContextAware {

	private MyFreemarkerUtil myFreemarkerUtil;
	
	@Override
	public MyFreemarkerUtil getObject() throws Exception {
		return myFreemarkerUtil;
	}

	@Override
	public Class<?> getObjectType() {
		return MyFreemarkerUtil.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
	private ServletContext servletContext;
	private String basePackagePath;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public void setBasePackagePath(String basePackagePath) {
		this.basePackagePath = basePackagePath;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		myFreemarkerUtil = new MyFreemarkerUtil();
		myFreemarkerUtil.init(servletContext, basePackagePath);
	}

}
