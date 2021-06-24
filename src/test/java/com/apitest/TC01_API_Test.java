package com.apitest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.DataReader;
import com.utils.ExtentTS;
import com.utils.RandomDataGenerator;

import io.restassured.response.Response;

public class TC01_API_Test extends apiBaseClass {


	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = DataReader.getDataFromExcel(APITestDataPath);
		return testData.iterator();

	}


	@Test(priority = 1,groups= {"api","regression"})

	public void getRequestAPITest()

	{
		try {
			given()
			.get(getURI) //Getting the value from the apiBaseClass
			.then()
			.statusCode(200);
			ExtentTS.getInstance().getExtent().info("Get data request using get request is successful and returns statusCode 200");
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing get request APITest-GetRequestStatusCodeIs200");
			log.error("APITest: error while performing get request APITest-GetRequestStatusCodeIs200", e);

		}

	}

	@Test(dataProvider="getTestData", priority = 2,groups= {"api","regression"})

	public void postRequestAPITest(String username, double score)

	{
		try
		{
			JSONObject request = new JSONObject();
			conuser = username+RandomDataGenerator.generateRandomString();
			request.put("username", conuser);
			request.put("score", score);
			ExtentTS.getInstance().getExtent().info("Data added to the post request " + conuser + " with score " + score );
			given()
			.header("content-type","application/json")
			.body(request.toJSONString())
			.when()
			.post(postURI)
			.then()
			.statusCode(201)
			.and()
			.body("status",equalTo("success"))
			.and()
			.body("message",equalTo("User added."));
			ExtentTS.getInstance().getExtent().info("Post request successfully created and verified for "+ conuser + " with score " + score);
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing post request APITest-PostRequestValidation");
			log.error("APITest: error while performing post request APITest-PostRequestValidation", e);
		}
	}

	@Test(priority = 3,groups= {"api","regression"})

	public void validateCreatedUserThruPostAPITest()

	{
		try {
			Response res = given()
					.get(getURI) //Getting the value from the apiBaseClass
					.then()
					.statusCode(200)
					.log().all()
					.extract().response();
			Assert.assertTrue(res.asString().contains(conuser));
			ExtentTS.getInstance().getExtent().info("New data validated successfully which was created using post request with username as: "+ conuser);
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing get request APITest-ValidateCreatedUserThroughPost");
			log.error("APITest: error while performing get request APITest-ValidateCreatedUserThroughPost", e);

		}

	}

	@Test(priority = 4,groups= {"api","regression"})

	public void putRequestAPITest()

	{
		try
		{
			JSONObject request = new JSONObject();
			request.put("username", conuser);
			request.put("score", conscore);
			ExtentTS.getInstance().getExtent().info("Data updated from the put request " + conuser + " with score " + conscore );
			given()
			.header("content-type","application/json")
			.body(request.toJSONString())
			.when()
			.put(putURI)
			.then()
			.statusCode(204);	
			ExtentTS.getInstance().getExtent().info("Put request successfully updated the score for user: "+ conuser + " with current score: " + conscore);
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing put request APITest-PutRequestValidation");
			log.error("APITest: error while performing put request APITest-PutRequestValidation", e);
		}
	}

	@Test(priority = 5,groups= {"api","regression"})

	public void validateUpdatedUserThruPutAPITest()

	{
		try {
			Response res = given()
					.get(getURI) //Getting the value from the apiBaseClass
					.then()
					.statusCode(200)
					.log().all()
					.extract().response();
			Assert.assertTrue(res.asString().contains(conuser));
			Assert.assertTrue(res.asString().contains(String.valueOf(conscore)));
			ExtentTS.getInstance().getExtent().info("New data validated successfully which was created using put request with username as: "+ conuser + " and score of " + conscore);
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing get request APITest-ValidateUpdatedUserThroughPut");
			log.error("APITest: error while performing get request APITest-ValidateUpdatedUserThroughPut", e);

		}

	}

	@Test(priority = 6,groups= {"api","regression"})

	public void putRequestToCreateDataAPITest()

	{
		try
		{
			JSONObject request = new JSONObject();
			conuser = "Hero"+ RandomDataGenerator.generateRandomString();
			request.put("username", conuser);
			request.put("score", conscore);

			ExtentTS.getInstance().getExtent().info("New username created successfully as: "+ conuser+ " with score of "+conscore);
			given()
			.header("content-type","application/json")
			.body(request.toJSONString())
			.when()
			.put(putURI)
			.then()
			.statusCode(201)	
			.body("message",equalTo("User added with updated score"));
			ExtentTS.getInstance().getExtent().info("New data created successfully using put request with username as: "+ conuser + " and score of " + conscore);
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing put request in APITest-PutRequestCreateData");
			log.error("APITest: error while performing put request APITest-PutRequestCreateData", e);
		}
	}


	
	@Test(priority = 7,groups= {"api","regression"})

	public void blankDeleteKeyRequestAPITest()

	{
		try
		{
			ExtentTS.getInstance().getExtent().info("Performing delete request without delete key" );
			given()
			.header("delete-key","")
			.when()
			.delete(deleteURI)
			.then()
			.statusCode(401);	
			ExtentTS.getInstance().getExtent().info("As expected deletion failed without the delete key");
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing delete request");
			log.error("APITest: error while performing delete request", e);
		}
	}
	
	@Test(priority = 8,groups= {"api","regression"})

	public void incorrectDeleteKeyRequestAPITest()

	{
		try
		{
			ExtentTS.getInstance().getExtent().info("Performing delete request with incorrect delete key APITest-DeleteRequestValidationWithoutDeleteKey" );
			given()
			.header("delete-key",123)
			.when()
			.delete(deleteURI)
			.then()
			.statusCode(401);	
			ExtentTS.getInstance().getExtent().info("As expected deletion failed with incorrect delete key");
		}
		catch(Exception e)
		{
			System.out.println("APITest: error while performing delete request APITest-DeleteRequestValidationWithIncorrectDeleteKey");
			log.error("APITest: error while performing delete request APITest-DeleteRequestValidationWithIncorrectDeleteKey", e);
		}
	}

}