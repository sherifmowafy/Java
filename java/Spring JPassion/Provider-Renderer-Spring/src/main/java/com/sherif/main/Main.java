package com.sherif.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sherif.data.renderer.DataRenderer;
import com.sherif.data.renderer.IDataRenderer;

public class Main {

	public static void main(String[] args) {

		BeanFactory factory = new ClassPathXmlApplicationContext("/spring-config.xml");

		// IDataProvider dataProvider = (DataProvider)
		// factory.getBean("provider");

		IDataRenderer dataRenderer = (DataRenderer) factory.getBean("renderer");

		// dataRenderer.setDataProvider(dataProvider);

		dataRenderer.render();
	}

}
