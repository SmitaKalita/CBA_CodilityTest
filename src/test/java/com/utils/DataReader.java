package com.utils;

import java.util.ArrayList;

public class DataReader {
	static ExcelReader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(String Path)
	{
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		try
		{
			reader = new ExcelReader(System.getProperty("user.dir")+ Path);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum<=reader.getRowCount("UsersData"); rowNum++)
		
		{
			if(Path.contains("API")) {
			String username = reader.getCellData("UsersData", "username", rowNum);
			Double score = Double.valueOf(reader.getCellData("UsersData", "score", rowNum));
			
			Object d[]= {username,score};
			data.add(d);
			}
			else {
				String username = reader.getCellData("UsersData", "username", rowNum);
				Object d[]= {username};
				data.add(d);
				
			}
					
		}
		
		return data;
	}
	
}
