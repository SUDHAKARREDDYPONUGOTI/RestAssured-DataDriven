package DataDriven_testAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T002_DataDrive_MultipleData {
	
	@Test(dataProvider = "RegisterData")
	public void DataDriven_singleData(String email, String pwd) {
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		RequestSpecification httpreq = RestAssured.given();
		
		// Send the data as Body with JsonObject
		
		JSONObject reqParams = new JSONObject();
		reqParams.put("email", email);
		reqParams.put("password", pwd);
		
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
	
	
	@DataProvider(name="RegisterData")
	String[][] getRegData() {
		
		String[][] regData = {{"eve.holt@reqres.in","pistol"}, {"eve.holt@reqres123.in","pistol1"}};
		return(regData);
		
	}


}
