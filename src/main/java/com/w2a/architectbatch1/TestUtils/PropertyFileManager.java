package com.w2a.architectbatch1.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
	
	
	private static String configFilePath;
	//private String ORFilePath;
	public static Properties config=new Properties();
	//public static Properties or=new Properties();
	private static File file;
	private static  FileInputStream fis;
	
	public static String getConfigFilePath() {
		return configFilePath;
	}
	public static void setConfigFilePath(String config) {
		configFilePath = config;
	}
	public static Properties createConfigFileProperty()
	{
		file=new File(getConfigFilePath());
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
	
	
	
	
	
	// File
	//FileInputStream
	//config.load()

}
