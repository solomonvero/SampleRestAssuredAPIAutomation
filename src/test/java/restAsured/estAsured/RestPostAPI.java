package restAsured.estAsured;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPostAPI {

		@Test
	public static void postUsers()
	{
			//get base URI
	RestAssured.baseURI="https://reqres.in";
	//Create request object
	RequestSpecification httprequest = RestAssured.given();
	//payload to send with the post request
	JSONObject requestparameter = new JSONObject();
	requestparameter.put("name","morpheus");
	requestparameter.put("job","leader");
	httprequest.header("Content-Type","application/json");
	httprequest.body(requestparameter.toJSONString());
	//response object
	Response response =httprequest.request(Method.POST,"/api/users");
	//print response in console
	String responsebody=response.getBody().asString();
	System.out.println("Response body is \n :" +responsebody);
	//status code validation
	int responsecode = response.getStatusCode();
	System.out.println("The response code is "+responsecode);
	Assert.assertEquals(responsecode,201);
	//status line verification
String statusline = response.getStatusLine();
System.out.println("The response line is "+statusline);
Assert.assertEquals(statusline,"HTTP/1.1 201 Created");
	}

	}

