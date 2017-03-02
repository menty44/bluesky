package com.blaqueyard.tests;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.UnsupportedEncodingException; 
import java.security.NoSuchAlgorithmException; 

public class encryption {
	
	public static void main(String arg[]) throws Exception {
	    System.out.println(encrypt("root"));
	  }

	  public static byte[] encrypt(String x) throws Exception {
	    java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(x.getBytes());
	    return d.digest();
	  }

}
