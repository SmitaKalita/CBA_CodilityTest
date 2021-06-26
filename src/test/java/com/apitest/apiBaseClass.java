package com.apitest;


import com.utils.ReadConfig;
import com.utils.SetUpReporting;



public class apiBaseClass extends SetUpReporting {
	ReadConfig readconfig = new ReadConfig();// reading the config.properties file
	public String getURI = readconfig.getGetURI();
	public String postURI = readconfig.getPostURI();
	public String putURI = readconfig.getPutURI();
	public String deleteURI = readconfig.getDeleteURI();
	public String APITestDataPath = readconfig.getAPITestDataPath();
	public static String conuser;
	public static int conscore = 1604;

	

}
