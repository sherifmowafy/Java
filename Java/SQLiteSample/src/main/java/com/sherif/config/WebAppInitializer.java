package com.sherif.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@Order(2)
public class WebAppInitializer implements WebApplicationInitializer {

	final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		//WEB-INF Path 
		String webinfPath = servletContext.getRealPath("/WEB-INF");
		System.setProperty("WEB-INF.path", webinfPath);
		
		////
		// Root Configuration
		////

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(new Class[]{SecurityConfig.class, DatabaseConfig.class});
		//ctx.setConfigLocations(new String[]{"com.sherif.config.WebConfig"});
		servletContext.addListener(new ContextLoaderListener(ctx));
		
		////
		//Servlet Configuration
		////
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(new Class[]{ WebConfig.class});

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(dispatcherContext));
		dispatcherServlet.addMapping("/");
		//dispatcherServlet.addMapping("*.pdf");
		dispatcherServlet.setLoadOnStartup(1);
		
		logger.trace("App Start");



	}



}
