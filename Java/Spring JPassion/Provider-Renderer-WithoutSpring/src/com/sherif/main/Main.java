package com.sherif.main;

import com.sherif.data.factory.DataSupportFactory;
import com.sherif.data.provider.IDataProvider;
import com.sherif.data.renderer.IDataRenderer;

public class Main {

	public static void main(String[] args) {
		
		DataSupportFactory dataSupportFactory =  DataSupportFactory.getInstance(); 
		
		IDataProvider dataProvider = dataSupportFactory.getDataProvider();
		
		IDataRenderer dataRenderer = dataSupportFactory.getDataRenderer();
		
		dataRenderer.setDataProvider(dataProvider);
		
		dataRenderer.render();
	}

}
