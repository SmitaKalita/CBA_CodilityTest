package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties pro; // CREATE A OBJECT
	public static String DirFilePath = System.getProperty("user.dir");
	

	public ReadConfig()

	{
		File src = new File(DirFilePath +"\\ConfigFiles\\config.properties");//obtain the file 

		try
		{
			FileInputStream fil= new FileInputStream(src);//read the file,opening the file
			pro = new Properties();
			pro.load(fil); // load the complete file


		}catch(Exception e)

		{ 

			System.out.println("there is an exception "+ e.getMessage());


		}
	}
	// Read config data for API framework
	public String getGetURI()

	{
		String getURI= pro.getProperty("getURI");
		return getURI;

	}
	public String getPostURI()

	{
		String postURI= pro.getProperty("postURI");
		return postURI;

	}
	public String getPutURI()

	{
		String putURI= pro.getProperty("putURI");
		return putURI;

	}
	public String getDeleteURI()

	{
		String deleteURI= pro.getProperty("deleteURI");
		return deleteURI;

	}

	// Read config data for UI framework
	public String getapplicationURL()

	{
		String URL= pro.getProperty("siteURL");
		return URL;

	}

	public String getLoginPageTitle()

	{

		String loginPageTitle = pro.getProperty("loginPageTitle");
		return loginPageTitle;
	}


	public String getHomePageTitle()

	{

		String homePageTitle = pro.getProperty("homePageTitle");
		return homePageTitle;
	}

	public String getAPITestDataPath()

	{

		String apiDataPath = pro.getProperty("APITestDataPath");
		return apiDataPath;
	}

	public String getWebTestDataPath()

	{

		String webDataPath = pro.getProperty("WebTestDataPath");
		return webDataPath;
	}
	
	public String getHomepageHeader()

	{

		String homepageHeader = pro.getProperty("HomePageHeader");
		return homepageHeader;
	}


}

