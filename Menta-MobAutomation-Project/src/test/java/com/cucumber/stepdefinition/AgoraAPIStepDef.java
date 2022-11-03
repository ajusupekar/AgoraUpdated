package com.cucumber.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.auth.AuthOption;
import org.testng.Assert;

import com.appium.utility.Constants;
import com.sun.xml.bind.v2.runtime.output.Encoded;
import com.utility.LogCapture;
import com.utility.SendMail;

public class AgoraAPIStepDef 
{
	public static String devAccessToken97 ;
	public static String sitAccessToken30 ;
	public static String stagAccessToken25 ;
	public static int actStatusCode ;
	//public static int expStatusCode = 200;
	
	
	@Given("^User hit the POST http request \"([^\"]*)\" for token on DEV$")
	public void user_hit_the_POST_http_request_for_token_on_DEV(String devPOST) throws Throwable 
	{
		RestAssured.baseURI = devPOST ;
        String response = given()
        		.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
        		.header("Authorization" , "Basic MTIzNDptb3JuaW5n")
        	    .formParam("username", "morning-jump")
        	    .formParam("password", "morning")
        	    .formParam("grant_type", "password")
        		.when()
        		.post(devPOST)
        		.then()
        		.assertThat().statusCode(200)
        		.extract().response().asString();
        LogCapture.info("97 Dev Env POST Request Response : "+response);
        //System.out.println("97 Dev Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        devAccessToken97 = js.getString("access_token");
        LogCapture.info("97 Dev Environment Access Token Is : "+devAccessToken97);
        //System.out.println("97 Dev Environment Access Token Is : "+devAccessToken97);		          			
	}

	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on DEV$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details(String devGET) throws Throwable 
	{				
		RestAssured.baseURI = devGET;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ devAccessToken97);
       
        Response response = httpRequest.get(devGET);
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        LogCapture.info(bodyStringValue);
        //System.out.println(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}

	@Then("^User validate the Status code as \"([^\"]*)\" on DEV$")
	public void user_validate_the_Status_code_as(String Scode) throws Throwable 
	{
		//System.out.println("Status code of GET User details request on DEV --- "+actStatusCode);
		LogCapture.info("Status code of GET User details request on DEV --- "+actStatusCode);
		
		int expStatusCode = Integer.parseInt(Scode);
		
		if(actStatusCode == expStatusCode)
		{
			LogCapture.info("97 DEV Server is up and running successfully...");
		}
		else 
		{
			LogCapture.info("97 DEV Server is not up and running...");
			//SendMail.execute("AAA");
		}
	}
	
	@Given("^User hit the POST http request \"([^\"]*)\" for token on SIT$")
	public void user_hit_the_POST_http_request_for_token_on_SIT(String sitPOST) throws Throwable 
	{
		RestAssured.baseURI = sitPOST ;
        String response = given()
        		.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
        		.header("Authorization" , "Basic MTIzNDptb3JuaW5n")
        	    .formParam("username", "morning-jump")
        	    .formParam("password", "morning")
        	    .formParam("grant_type", "password")
        		.when()
        		.post(sitPOST)
        		.then()
        		.assertThat().statusCode(200)
        		.extract().response().asString();
        //System.out.println("30 Sit Env POST Request Response : "+response);
        LogCapture.info("30 Sit Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        sitAccessToken30 = js.getString("access_token");
        //System.out.println("30 Sit Environment Access Token Is : "+sitAccessToken30);
        LogCapture.info("30 Sit Environment Access Token Is : "+sitAccessToken30);
	}
	
	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on SIT$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details_on_SIT(String sitGET) throws Throwable 
	{
		//System.out.println(sitAccessToken30);
		LogCapture.info(sitAccessToken30);
		RestAssured.baseURI = sitGET;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ sitAccessToken30);
       
        Response response = httpRequest.get(sitGET);
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        //System.out.println(bodyStringValue);
        LogCapture.info(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}
	
	@Then("^User validate the Status code as \"([^\"]*)\" on SIT$")
	public void user_validate_the_Status_code_as_on_SIT(String Scode) throws Throwable 
	{
		//System.out.println("Status code of GET User details request on SIT --- "+actStatusCode);
		LogCapture.info("Status code of GET User details request on SIT --- "+actStatusCode);
		
		int expStatusCode = Integer.parseInt(Scode);
		
		if(actStatusCode == expStatusCode)
		{
			LogCapture.info("30 SIT Server is up and running successfully...");
		}
		else 
		{
			LogCapture.info("30 SIT Server is not up and running...");
			//SendMail.execute("AAA");
		}
	}
	
	@Given("^User hit the POST http request \"([^\"]*)\" for token on Stagging$")
	public void user_hit_the_POST_http_request_for_token_on_Stagging(String stagPOST) throws Throwable 
	{
		RestAssured.baseURI = stagPOST ;
        String response = given()
        		.header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
        		.header("Authorization" , "Basic MTIzNDpzYW5kYm94QEFnb3Jh")
        	    .formParam("username", "sandbox-user")
        	    .formParam("password", "Agora@2022")
        	    .formParam("grant_type", "password")
        		.when()
        		.post(stagPOST)
        		.then()
        		.assertThat().statusCode(200)
        		.extract().response().asString();
        //System.out.println("25 Stagging Env POST Request Response : "+response);
        LogCapture.info("25 Stagging Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        stagAccessToken25 = js.getString("access_token");
        //System.out.println("25 Stagging Environment Access Token Is : "+stagAccessToken25);
        LogCapture.info("25 Stagging Environment Access Token Is : "+stagAccessToken25);
	}

	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on Stagging$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details_on_Stagging(String stagGET) throws Throwable
	{
		//System.out.println(stagAccessToken25);
		LogCapture.info(stagAccessToken25);
		RestAssured.baseURI = stagGET;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ stagAccessToken25);
       
        Response response = httpRequest.get(stagGET);
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        //System.out.println(bodyStringValue);
        LogCapture.info(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}

	@Then("^User validate the Status code as \"([^\"]*)\" on Stagging$")
	public void user_validate_the_Status_code_as_on_Stagging(String Scode) throws Throwable 
	{
		//System.out.println("Status code of GET User details request on Stagging --- "+actStatusCode);
		LogCapture.info("Status code of GET User details request on Stagging --- "+actStatusCode);
		
		int expStatusCode = Integer.parseInt(Scode);
		
		if(actStatusCode == expStatusCode)
		{
			LogCapture.info("25 Stagging Server is up and running successfully...");
		}
		else 
		{
			LogCapture.info("25 Stagging Server is not up and running...");
			//SendMail.execute("AAA");
		}
	}
	
	
	
	/*      Titan Cards API      */
	
	@Given("^User hit the POST http request \"([^\"]*)\" for bearer token$")
	public void user_hit_the_POST_http_request_for_bearer_token(String tokenReq) throws Throwable 
	{
		String vTokenReq = Constants.CONFIG.getProperty(tokenReq);
		
		RestAssured.baseURI = vTokenReq ;
        String response = given()
        		.header("Content-Type", "application/x-www-form-urlencoded")
        		.header("Accept-Encoding" , "gzip,deflate")
        	    .header("Accept-Language", "en-US,en;q=0.8")
        	    .header("Accept", "application/x-www-form-urlencoded")
        	    .body("grant_type=password&client_id=auth_token_service&username=cd_api_user&password=Currenc!es@E145AA&client_secret=857f21c0-4c5d-4022-8c0c-4ead1ffdb6fc")
        		.when()
        		.post(vTokenReq)
        		.then()
        		.assertThat().statusCode(200)
        		.extract().response().asString();
        LogCapture.info("HTTP Post request of token API response is : "+response);
       
        JsonPath js = new JsonPath(response);
        Constants.bearerToken = js.getString("access_token");
        LogCapture.info("Access token is : "+Constants.bearerToken);
	}
	
	@When("^User hit the POST http request \"([^\"]*)\" for getting balance amount of customer ID \"([^\"]*)\"$")
	public void user_hit_the_POST_http_request_for_getting_balance_amount_of_customer_ID(String getBalanceReq, String customerID) throws Throwable 
	{
		
		
		HashMap<String, Object> getBalReqBody = new HashMap<>();
		getBalReqBody.put("eventId", "fc958869-5f34-475b-b311-eac338a0d84f");
		getBalReqBody.put("cdCustomerRef", customerID);
		getBalReqBody.put("baseCurrency", "GBP");
	
		String vGetBalanceReq = Constants.CONFIG.getProperty(getBalanceReq);
		
		RestAssured.baseURI = vGetBalanceReq;
		String response = given()
				 .body(getBalReqBody)
				 .header("Content-Type","application/json")
                 .header("Authorization","Bearer "+Constants.bearerToken)
                 .when()
                 .post(vGetBalanceReq)
                 .then()
                 .assertThat().statusCode(200)
                 .extract().response().asString();
        LogCapture.info("HTTP Post request of Get Balance API response is : "+response);
        
        JsonPath js = new JsonPath(response);
        String actualBalance = js.getString("actualBalance");
        String availableBalance = js.getString("availableBalance");
        LogCapture.info("Actual Balance of above customer is : "+actualBalance);
        LogCapture.info("Available Balance of above customer is : "+availableBalance);
        
        Constants.responseCode = js.getString("response_code");
        LogCapture.info("Response Code of get balance API is : "+Constants.responseCode);
	}
	
	@Then("^User validate the Response code \"([^\"]*)\"$")
	public void user_validate_the_Status_code(String expResCode) throws Throwable 
	{
		Assert.assertEquals(Constants.responseCode, expResCode);
		LogCapture.info("Response code is verified for get balance API....");
	}
	
}
