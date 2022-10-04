package restAsured.estAsured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestGetApi
{
	@Test
public static void getListofUsers()
{
		//get base URI
RestAssured.baseURI="https://reqres.in";
//request object
RequestSpecification httprequest = RestAssured.given();
//response object
Response response =httprequest.request(Method.GET,"/api/users/2");
//print response in console
String responsebody=response.getBody().asString();
System.out.println("Response body is \n :" +responsebody);

}

}
