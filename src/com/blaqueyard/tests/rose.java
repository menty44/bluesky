package com.blaqueyard.tests;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.json.simple.parser.ParseException;

public class rose {
	
	public static void main (String[]args) throws NoSuchAlgorithmException, IOException, ParseException{
		
		user ts = new user();
		ts.sendGET();
		
		group gp = new group();
		gp.sendGET();
		
		store st = new store();
		st.sendGET();
	}

}
