package rest_test;

import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.*;


public class test_req_ex {
	
	/*@Test
	public void ex_1()
	{
		given().
		 get("https://61a24ef2014e1900176de8d8.mockapi.io/Students")
		.then().
		 statusCode(200)
		.log().all();
	}*/
	
	@Test
	public void ex_2() 
	{
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("email","moh.hela_94@gmail.com");
		
		
		//given().post("https://reqres.in/api/users").then().statusCode(201).
		
		//given().get("https://reqres.in/api/users").then().statusCode(200).log().all();
		
		JSONObject request = new JSONObject(map);
		request.put("country","egypt");
		request.put("Firstname", "Fiji");
		request.put("Lastname", "Fiji");
		request.put("title", "Fiji");
		//System.out.println(request.toJSONString());
		given().body(request.toJSONString()).when().post("https://61a24ef2014e1900176de8d8.mockapi.io/Students/").then().statusCode(201).log().all();
	
		given().
		 get("https://restful-booker.herokuapp.com/booking/")
		.then().
		 statusCode(200)
		.log().all();
	}

}
