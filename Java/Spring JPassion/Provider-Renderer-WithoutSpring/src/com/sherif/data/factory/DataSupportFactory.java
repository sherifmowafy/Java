package com.sherif.data.factory;

import java.io.IOException;
import java.util.Properties;

import com.sherif.data.provider.IDataProvider;
import com.sherif.data.renderer.IDataRenderer;

public class DataSupportFactory {

	private static DataSupportFactory dataSupportFactory;
	private IDataRenderer dataRenderer;
	private IDataProvider dataProvider;

	private Properties props ;
	
	public DataSupportFactory(){
		
		props = new Properties();
		try {
			props.load(DataSupportFactory.class.getResourceAsStream("/properties/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String rendererClassName =  props.getProperty("renderer.class");
		String providerClassName =  props.getProperty("provider.class");
		
		try {
			dataRenderer = (IDataRenderer) Class.forName(rendererClassName).newInstance();
			dataProvider = (IDataProvider) Class.forName(providerClassName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static{
		dataSupportFactory = new  DataSupportFactory();
	}
	
	public static DataSupportFactory getInstance(){
		return dataSupportFactory;
	}
	
	public IDataProvider getDataProvider() {
		return dataProvider;
	}
	
	public IDataRenderer getDataRenderer() {
		return dataRenderer;
	}

	
}
