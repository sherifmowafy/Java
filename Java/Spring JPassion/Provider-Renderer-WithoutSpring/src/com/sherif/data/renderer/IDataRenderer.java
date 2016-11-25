package com.sherif.data.renderer;

import com.sherif.data.provider.IDataProvider;

public interface IDataRenderer {
	
	IDataProvider getDataProvider();
	
	void setDataProvider(IDataProvider dataProvider);
	
	void render();
	
}
