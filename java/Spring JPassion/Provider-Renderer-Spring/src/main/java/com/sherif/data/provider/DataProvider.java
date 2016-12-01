package com.sherif.data.provider;

public class DataProvider implements IDataProvider {

	private String message;

	public DataProvider(String message) {
		this.message = message;
	}

	@Override
	public String getData() {
		return "Hello World Data Provider (" + message + ")";
	}

}
