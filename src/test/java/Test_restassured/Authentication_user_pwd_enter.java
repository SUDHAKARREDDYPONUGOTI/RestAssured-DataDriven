package Test_restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication_user_pwd_enter {
	
	@Test
	public void enter_Authentication_user_pwd() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		//******* able to enter basic Authentication Username and password
		
		PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
		basicAuth.setUserName("TestUserName");
		basicAuth.setPassword("testPassword");
		RestAssured.authentication=basicAuth;
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response resp = httpreq.request(Method.GET,"/");
		
	
		
		
		String respbody= resp.getBody().asString();
		System.out.println("Response Body is : " + respbody);
		
	
	}

}
