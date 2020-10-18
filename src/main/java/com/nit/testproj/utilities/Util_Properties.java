package com.nit.testproj.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util_Properties {
	public Properties p;
	public Util_Properties() {
		InputStream is;
		try {
			is = new FileInputStream("./resources/Global.properties");
			p=new Properties();
			p.load(is);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
