package com.prathmesh.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configreader {

	private static Properties prop ;
	public static void loadproperties ()  {
		try {
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
	     prop = new Properties();
		prop.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static String getproperties (String key) {
		if(prop==null) {
			loadproperties();
		}
		return prop.getProperty(key);
	}
	
	
}
