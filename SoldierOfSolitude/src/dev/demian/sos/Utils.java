package dev.demian.sos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// a class with utilities for file reading
public class Utils {
	
	//reads file line by line and stores it in a string builder which allows me to load in a world
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
			{
				builder.append(line + "\n");
			}
			br.close();
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return builder.toString();
		
		
		
	}
	//converts strings to integers and tells me if they are not in the correct format
	public static int parseInt(String number)
	{
		try
		{
			return Integer.parseInt(number);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
