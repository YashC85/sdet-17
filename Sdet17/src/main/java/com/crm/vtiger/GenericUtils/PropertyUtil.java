package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
	/*
	 * This method is used to read data from properties and return the values based on key specified
	 *@param key
	 *@throws Throwable
	 *return values
	 */
	public String getPropertyKeyValue(String key) throws Throwable{
		FileInputStream file = new FileInputStream("./Data/CommonData.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}

}
