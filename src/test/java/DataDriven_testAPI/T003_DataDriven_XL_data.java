package DataDriven_testAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import XLUtil.xlsxfile_read_util;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T003_DataDriven_XL_data extends xlsxfile_read_util {
	
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
		
		// Need xlsx file utility 
		// read and write the row and cloumn data 
		
		/*
		 * String path = System.getProperty("user.dir")+"/src/main/test.xml"; int
		 * rowCount = xlutil.getrowcount(); int colCount = xlutil.getColumcount();
		 * String [][] empdata = new String [rowCount][colCount]; for (int i = 1; i <
		 * rowCount; i++) {
		 * 
		 * for (int j = 0; j < colCount; j++) {
		 * 
		 * empdata[i-1][j] = xlutil.getCelldata(path,"sheet", i,j);
		 * 
		 * } }
		 */
		
		String[][] regData = {{"eve.holt@reqres.in","pistol"}, {"eve.holt@reqres123.in","pistol1"}};
		return(regData);
		
	}

}
