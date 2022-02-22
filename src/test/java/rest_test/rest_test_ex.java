package rest_test;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;



public class rest_test_ex 
{
	@Test(enabled=true)
    public void getrequesttest() {
		
        baseURI="https://jsonplaceholder.typicode.com/";
		
		String r1 = given()
				.when().get("/users?id=3").
                 then().assertThat()
                .statusCode(200).
                 extract()
                .asString();

		System.out.println(r1);
        JsonPath useremail = new JsonPath(r1);
        String emailAddress = useremail.getString("email");
        System.out.println(emailAddress);
    }

    @Test(enabled=true)
    public void getposts() {
        String r2 = given().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts?userId=3")
                .then().assertThat().statusCode(200).extract().asString();
        
        String postId = r2.toString();
        System.out.println(postId);
    }
    
    @Test(enabled=true)
    public void postrequesttest()
    {	
    	Map <String,Object>map=new  HashMap<String,Object>();
    	JSONObject request=new JSONObject();
    	
    	request.put("id"," 31");
    	request.put("title"," helal");
    	request.put("body"," i want to go");
    	request.put("userID"," 3");
    	System.out.println(request.toJSONString());
    	
    	baseURI="https://jsonplaceholder.typicode.com/";
    	
    	given().body(request.toJSONString()).when().post("/posts?userId=3").then().assertThat().statusCode(201).log().all(); 	    	
    }
}