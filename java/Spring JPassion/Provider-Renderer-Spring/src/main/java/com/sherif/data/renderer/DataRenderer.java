package com.sherif.data.renderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sherif.data.provider.IDataProvider;

@Component("renderer")
public class DataRenderer implements IDataRenderer {

	@Autowired
	private IDataProvider dataProvider;

	@Override
	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	@Override
	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	@Override
	public void render() {

		if (this.dataProvider == null) {
			throw new RuntimeException("The type \"" + IDataProvider.class.getCanonicalName() + "\" can't be null ");
		}
		System.out.println(this.dataProvider.getData());
	}
}
