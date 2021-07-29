package pac;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadData_JSON {

	public static void main(String[] args) throws IOException, ParseException {
	//FILE PATH	
		FileReader inputfile = new FileReader("../Sdet17/CommonData1.json");
		
	//Parse the json object into java data stream
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(inputfile);
		
	//typecast the object into hashmap and read the data in key-value format	
		HashMap jobj = (HashMap) obj;
	
		String value = jobj.get("Name").toString();
		System.out.println(value);
	}

}