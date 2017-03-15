package com.blaqueyard.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fred
 */
public class test{
    
    public String sendPOST() throws IOException, NoSuchAlgorithmException{
    	
    	String key = "action=create";
       //String url = "http://developer.cbagroup.com/api/CreditTransfer?api_key=cbatest123";
    	String url = "http://localhost:8080/smartshopper/WebserviceController?"+ key;
        URL object = new URL(url);
        HttpURLConnection con = (HttpURLConnection) object.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        //con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept", "application/json");
        
        String urlParameters = "name=hhh&";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
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
        
        ////////// start  ////////////////////
        String result = response.toString();

        
        JSONParser parser = new JSONParser();
        
        try {

            Object obj = parser.parse(result);

            JSONObject jsonObject = (JSONObject) obj;
            //System.out.println(jsonObject);
            
            long ResCode = (long) jsonObject.get("Response Code");
            System.out.println();
            System.out.println("Response Code : " + ResCode);
            System.out.println();
            
            if (ResCode == 1) {
            	
            	System.out.println("#########################################################");
				System.out.println("Fred hack Fail");
				System.out.println();
            	
            	long ResCode1 = (long) jsonObject.get("Response Code");
                System.out.println();
                System.out.println("Response Code : " + ResCode1);
                System.out.println();

                String Ref = (String) jsonObject.get("Reference");
                System.out.println();
                System.out.println("Reference : " +Ref);
                System.out.println();
                
                String Des = (String) jsonObject.get("Description");
                System.out.println();
                System.out.println("Description : " + Des);
                System.out.println();
				
			} else {
				
				System.out.println("#########################################################");
				System.out.println("Fred hack Success");
				System.out.println();
				
				long ResCode1 = (long) jsonObject.get("Response Code");
                System.out.println();
                System.out.println("Response Code : " + ResCode1);
                System.out.println();

                String Ref = (String) jsonObject.get("Reference");
                System.out.println();
                System.out.println("Reference : " +Ref);
                System.out.println();
                
                String Des = (String) jsonObject.get("Description");
                System.out.println();
                System.out.println("Description : " + Des);
                System.out.println();

			}
            
            

//            long age = (Long) jsonObject.get("Description");
//            System.out.println(age);

            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
            //}

        } catch (ParseException e) {
            e.printStackTrace();
        }

    
        return response.toString();
    }
    
    
}
