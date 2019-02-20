package fr.epita.quizz.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Loads the data from application properties file

public class Configuration {
	private Properties properties;
	private static Configuration config;
	
	
	private Configuration() {
		this.properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("application.properties")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Configuration getInstance() {
		if (config == null) {
			config = new Configuration();
		}

		return config;
	}

	public String getPropertyValue(String configKey) {
		return properties.getProperty(configKey);
	}

}
