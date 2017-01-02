package com.sherif.data.provider;

import org.springframework.stereotype.Component;

@Component
public class DataProvider implements IDataProvider {

	@Override
	public String getData() {
		return "Hello World Data Provider ";
	}

}
