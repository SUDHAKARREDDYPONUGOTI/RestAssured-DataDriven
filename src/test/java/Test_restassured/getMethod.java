package Test_restassured;

import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getMethod {
	
	@Test
	public void getMethod1() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response resp = httpreq.request(Method.GET,"/api/users?page=2");
		
		String respbody = resp.getBody().asString();
		
		System.out.println("Response Body is : " + respbody);
		
		int statuscode = resp.getStatusCode();
		
		System.out.println("Status code is : " + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String respLine = resp.getStatusLine();
		System.out.println("Status Line is : " + respLine);
		Assert.assertEquals(respLine, "HTTP/1.1 200 OK");
	
		
	}

}
