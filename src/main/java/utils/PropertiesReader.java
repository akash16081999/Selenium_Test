package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	Properties pro;
	static PropertiesReader prop = null;

	public PropertiesReader() throws IOException {

		pro = new Properties();
		pro.load(new FileInputStream("./propertyFiles/EatEasyLogin.properties"));

	}

	public static PropertiesReader getInstancePropertyReader() {

		try {
			prop = new PropertiesReader();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return prop;

	}

	public String getUsername() {
		return pro.getProperty("username");

	}

	public String getPassword() {
		return pro.getProperty("password");

	}

}
