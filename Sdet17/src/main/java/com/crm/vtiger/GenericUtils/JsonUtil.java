package com.crm.vtiger.GenericUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class JsonUtil {
	
	/*
	 *this method will return json value based on json key
	 *@param jsonkey
	 *return jsonvalue
	 *@throws Throwable
	 */
	public String readDataFromJson(String key) throws Throwable, ParseException
	{
		//Read data from Json File
		FileReader inputFile = new FileReader(IPathConstant.JSONFILEPATH);
		
		//Parser the json object into java
		JsonParser parser = new JsonParser();
		Object object = parser.parse(inputFile);
		
		//Type cast the object into HashMap and read the data in the key value format
		HashMap jObject = (HashMap) object;
		String value = jObject.get(key).toString();
		return value;		
	}

}
