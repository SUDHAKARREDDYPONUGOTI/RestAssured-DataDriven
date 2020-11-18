package Test_restassured;

import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getAllHeaders {
	
	@Test
	public void getAllHeadersdata() {
		
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

	}

}
