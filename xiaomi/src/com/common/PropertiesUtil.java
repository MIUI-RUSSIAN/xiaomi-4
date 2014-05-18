package com.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesUtil {

	/**
	 * 读取.properties文件
	 * @param fileName
	 * @return
	 */
	public static Enumeration<?> getKeys(Properties p,String fileName) {
		InputStream in = null;
		try {
			in = new FileInputStream(System.getProperty("user.dir")+"\\config\\"+fileName);
			p.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 Enumeration<?> keys = p.elements();
		return keys;
	}

}
