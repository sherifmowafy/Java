package com.sherif.data.renderer;

import com.sherif.data.provider.IDataProvider;

public class DataRenderer implements IDataRenderer {

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
