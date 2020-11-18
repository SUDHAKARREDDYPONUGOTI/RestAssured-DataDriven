package Test_restassured;

import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_validate_ResponseBody {
	
	@Test
	public void validateresponseBody() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response resp = httpreq.request(Method.GET,"/api/users?page=2");
		
		String respbody= resp.getBody().asString();
		System.out.println("Response Body is : " + respbody);
		
		int StatusCode = resp.statusCode();
		System.out.println("Statuc Code is : " + StatusCode);
		
		String StatusLine = resp.statusLine();
		System.out.println("StatusLine is : " + StatusLine);
		
		// get all headers 
		Headers allheaders=resp.headers();
		
		for (Header header : allheaders) {
			
			System.out.println(header.getName()+ " --> "+header.getValue());
			
		}
		
		// get and Validate the response Body
		
		JsonPath jsonresp = resp.jsonPath();
		
		System.out.println("Total value is : " + jsonresp.get("total"));
		System.out.println("Total value is : " + jsonresp.get("data[0].email"));
		System.out.println("Total value is : " + jsonresp.get("data[0].id"));
		System.out.println("Total value is : " + jsonresp.get("data[0].first_name"));
		System.out.println("Total value is : " + jsonresp.get("data[0].last_name"));
		System.out.println("Total value is : " + jsonresp.get("data[0].avatar"));
		
		Assert.assertEquals(jsonresp.get("total"), 12);
		
		
		
	}

}
