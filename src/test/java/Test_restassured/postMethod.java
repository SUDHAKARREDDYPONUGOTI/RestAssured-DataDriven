package Test_restassured;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postMethod {
	
	@Test
	public void postMethod1() {
		
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httpreq = RestAssured.given();
		
		
		
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.put("email", "eve.holt@reqres.in");
		jsonobj.put("password", "cityslicka");
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(jsonobj.toJSONString());
		
		Response resp = httpreq.request(Method.POST,"\r\n" + 
				"/api/register");
		
		int StatusCode = resp.getStatusCode();
		System.out.println("Response Body is : " + StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		String respStatusLine = resp.getStatusLine();
		System.out.println("Response Status Line : " + respStatusLine);
		Assert.assertEquals(respStatusLine, "HTTP/1.1 200 OK");
		
		String respbody  = resp.getBody().asString();
		System.out.println("Response Body is : " + respbody);
		
		
		
	}

}
