package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Raghavendra Karanth S
 *
 */
public class FileUtility {
	public FileInputStream fprop;
	public static Map<String, String> propMap = new HashMap<String, String>();
	/**
	 * used to get common data from property file for vtiger based on key which you have specified as argument
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertiesForVtiger(String Key) throws Throwable {
		Properties prop = new Properties();
		prop.load(new FileInputStream(IPathConstants.vtigerFilePath));
		
		Enumeration keys = prop.propertyNames();
		while(keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			String value = prop.getProperty(key);
			propMap.put(key, value);
		}
		
		return propMap.get(Key);
	}
	
	/**
	 * used to get common data from property file for RMG based on key which you have specified as argument
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertiesForRmg(String Key) throws Throwable {
		fprop = new FileInputStream(IPathConstants.rmgFilePath);
		Properties prop = new Properties();
		prop.load(fprop);
		String value = prop.getProperty(Key);
		return value;
		
	}
	/**
	 * to close opened property files
	 * @throws Throwable
	 */
	public void closePropFiles() throws Throwable {
		fprop.close();
	}
}
