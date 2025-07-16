package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utilities {
	
	/**
	 *This method id used to read the data from Properties file(External Resource)
	 *@param key
	 *@return
	 *@throws Throwable
	 *@author Sumitha 
	 */
	
	public String getKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		//create object for Properties class and load the value
		Properties prop = new Properties();
		prop.load(fis);
		
		//read the values using getProperties
		String value = prop.getProperty(key);
		
		return value;
	}

}
