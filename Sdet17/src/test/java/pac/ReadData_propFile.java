package pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData_propFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("../Sdet17/CommonData.properties"));
		System.out.println("Name =\t"+p.getProperty("Name"));
		System.out.println(p.getProperty("Branch"));
		System.out.println(p.getProperty("MobNo"));
		System.out.println(p.getProperty("Designation"));
		System.out.println(p.getProperty("Company"));
	}

}
