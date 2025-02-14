package com.jqueryui.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;

	// Static block to initialize the properties file
	static {

		try {
			FileInputStream fis = new FileInputStream("src/main/resources/config.properties");//FileInputStream is used to read binary data from the given file.
			properties = new Properties();
			properties.load(fis);

		} catch (IOException e) {

			throw new RuntimeException("Failed to load config.properties file" + e.getMessage());
		}

	}
	
	 // Method to get a property value by key
	public static String getProperty(String key) {

		return properties.getProperty(key);

	}

}
