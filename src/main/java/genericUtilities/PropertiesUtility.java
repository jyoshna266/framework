package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private Properties property;

	public void propertiesInit(String filepath) {
		FileInputStream fis =  null;
		try {
			fis = new FileInputStream(filepath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		property.new properties();
		try {
			property.load(fis);
		}catch (IOException e) {
			e.printStackTrace();
}
}
/**
 * *This method fetches data from properties file based on the key passed 
 * as an arrgument
 * @param key
 * @return
 */
public String readFromroperties(String key) {
	return property.getProperty(key);
	}
}


}
