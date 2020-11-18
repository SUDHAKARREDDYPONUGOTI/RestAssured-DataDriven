import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_gerReq {
	
	@Test
	void getReqDetails() {
		
		// Base URI setup
		RestAssured.baseURI = "https://reqres.in/api";
		
		// Req Object
		RequestSpecification httpReq = RestAssured.given();
		
		//Response Object
		Response response = httpReq.request(Method.GET,"/users?page=2");
		
		String respbody = response.getBody().asString();
		
		System.out.println("Response Body is :" + respbody);
		
		int statuscode  = response.getStatusCode();
		
		System.out.println("Status Code is : " + statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String statusline = response.getStatusLine();
		System.out.println("Status Line is : " + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	}

}
