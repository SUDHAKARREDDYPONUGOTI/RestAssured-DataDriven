package DataDriven_testAPI;

import java.lang.module.ResolutionException;

import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T001_DataDriven_Singledata_post {
	
	@Test
	public void DataDriven_singleData() {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification httpreq = RestAssured.given();
		
		// Send the data as Body with JsonObject
		
		JSONObject reqParams = new JSONObject();
		reqParams.put("email", "eve.holt@reqres.in");
		reqParams.put("password", "pistol");
		
		// add one header
		httpreq.header("Content-Type","application/json");
		
		// add Json to body
		httpreq.body(reqParams.toJSONString());
		
		Response reqresp = httpreq.request(Method.POST,"/register");
		
		int statuscode = reqresp.statusCode();
		System.out.println("Statuc code is : " + statuscode);
		
		String respbody = reqresp.getBody().asString();
		
		System.out.println("Responce Body is : " + respbody);
	}

}
