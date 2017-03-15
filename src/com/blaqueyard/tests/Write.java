package com.blaqueyard.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class Write {

	public static void main(String[] args) {
		String fred = Long.toString(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
		String content = fred;
		
		//begin
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("rose.txt")))){
			bw.write(content);
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
