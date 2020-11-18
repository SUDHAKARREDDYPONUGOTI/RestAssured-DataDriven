import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_POSTReq {
	
	@Test
	void postDetails() {
		
		RestAssured.basePath = "https://reqres.in";
		
		RequestSpecification httpreqs = RestAssured.given();
		
		JSONObject reqsparams  = new JSONObject();
		
		reqsparams.put("name", "Driver BABU 123");
		reqsparams.put("job", "CAR Driver");
		
		httpreqs.header("Content-Type", "application/json; charset=utf-8");
		httpreqs.body(reqsparams.toJSONString());

		
		Response response = httpreqs.request(Method.POST,"/api/users/1");
		
		String respbody = response.body().asString();
		System.out.println("Responce Body is : " + respbody);
		
		int respcode  = response.statusCode();
		System.out.println("Response Code is : " + respcode);
		Assert.assertEquals(respcode, 201);
		
	}
}
