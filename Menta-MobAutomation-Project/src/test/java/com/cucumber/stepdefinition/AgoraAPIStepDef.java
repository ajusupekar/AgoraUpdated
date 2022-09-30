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
        System.out.println("97 Dev Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        devAccessToken97 = js.getString("access_token");
        System.out.println("97 Dev Environment Access Token Is : "+devAccessToken97);		          			
	}

	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on DEV$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details(String devGET) throws Throwable 
	{				
		RestAssured.baseURI = "http://172.31.21.97:8888";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ devAccessToken97);
       
        Response response = httpRequest.get("/v2/users/2931291762603332769");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        System.out.println(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}

	@Then("^User validate the Status code as \"([^\"]*)\" on DEV$")
	public void user_validate_the_Status_code_as(String Scode) throws Throwable 
	{
		System.out.println("Status code of GET User details request on DEV --- "+actStatusCode);
		
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
        System.out.println("30 Sit Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        sitAccessToken30 = js.getString("access_token");
        System.out.println("30 Sit Environment Access Token Is : "+sitAccessToken30);
	}
	
	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on SIT$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details_on_SIT(String sitGET) throws Throwable 
	{
		System.out.println(sitAccessToken30);
		RestAssured.baseURI = "http://172.31.21.30:8888";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ sitAccessToken30);
       
        Response response = httpRequest.get("/v2/users/2930674112340694637");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        System.out.println(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}
	
	@Then("^User validate the Status code as \"([^\"]*)\" on SIT$")
	public void user_validate_the_Status_code_as_on_SIT(String Scode) throws Throwable 
	{
		System.out.println("Status code of GET User details request on SIT --- "+actStatusCode);
		
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
        System.out.println("25 Stagging Env POST Request Response : "+response);
        
        JsonPath js = new JsonPath(response);
        stagAccessToken25 = js.getString("access_token");
        System.out.println("25 Stagging Environment Access Token Is : "+stagAccessToken25);
	}

	@When("^User hit the GET http request \"([^\"]*)\" for getting the user details on Stagging$")
	public void user_hit_the_GET_http_request_for_getting_the_user_details_on_Stagging(String stagGET) throws Throwable
	{
		System.out.println(stagAccessToken25);
		RestAssured.baseURI = "http://172.31.21.25:8888";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Authorization", "Bearer "+ stagAccessToken25);
       
        Response response = httpRequest.get("/v2/users/2861095794616833496");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        System.out.println(bodyStringValue);
        actStatusCode = response.getStatusCode();
        //System.out.println(actStatusCode);
	}

	@Then("^User validate the Status code as \"([^\"]*)\" on Stagging$")
	public void user_validate_the_Status_code_as_on_Stagging(String Scode) throws Throwable 
	{
		System.out.println("Status code of GET User details request on Stagging --- "+actStatusCode);
		
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
	
	
}
