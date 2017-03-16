package com.sherif.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		//Database Path 
		String dbPath = servletContext.getRealPath("/WEB-INF");
		System.setProperty("WEB-INF.path", dbPath);


		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(new Class[]{WebConfig.class});
		//ctx.setConfigLocations(new String[]{"com.sherif.config.WebConfig"});
		servletContext.addListener(new ContextLoaderListener(ctx));

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(ctx));
		dispatcherServlet.addMapping("/");
		//dispatcherServlet.addMapping("*.pdf");
		dispatcherServlet.setLoadOnStartup(1);
		
		logger.trace("App Start");



	}



}
