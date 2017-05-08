package com.blaqueyard.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class store {
	
public String sendGET() throws IOException, NoSuchAlgorithmException, ParseException{
    	
    	String url = "http://localhost:8080/smartshopper/StoreCRUDController?action=count";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "USER_AGENT");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
        String result = response.toString();

        
        JSONParser parser = new JSONParser();
        
//        //try {
//
//            Object objone = parser.parse(result);
//
//            JSONObject jsonObject = (JSONObject) objone;
//            //System.out.println(jsonObject);
//            
//            String ResCode = (String) jsonObject.get("Result");
//            System.out.println();
//            System.out.println("Response Code : " + ResCode);
//            System.out.println();
//            
//            String success = "OK";
//            
//            if (ResCode == success ) {
//            	
//            	System.out.println("#########################################################");
//				System.out.println("Fred hack Fail");
//				            	
//            	long ResCode1 = (long) jsonObject.get("Response Code");
//                System.out.println();
//                System.out.println("Response Code : " + ResCode1);
//                System.out.println();
//
//                String Ref = (String) jsonObject.get("Reference");
//                System.out.println();
//                System.out.println("Reference : " +Ref);
//                System.out.println();
//                
//                String Des = (String) jsonObject.get("Description");
//                System.out.println();
//                System.out.println("Description : " + Des);
//                System.out.println();
//				
//			} else {
//				
//				System.out.println("#########################################################");
//				System.out.println("Fred hack Success");
//				System.out.println();
//				
////				String res = (String) jsonObject.get("Result");
////                System.out.println();
////                System.out.println("Result : " + res);
////                System.out.println();
//
//                long Count = (long) jsonObject.get("DatabaseCount");
//                System.out.println();
//                System.out.println("DatabaseCount : " + Count);
//                System.out.println();
//               String t = Long.toString(Count);
//                
////                String Des = (String) jsonObject.get("Description");
////                System.out.println();
////                System.out.println("Description : " + Des);
////                System.out.println();
//
////			}catch (Exception e) {
////				// TODO: handle exception
////				e.printStackTrace();
////			}
//        
//
//	}
			return result ;
			}
    

}
