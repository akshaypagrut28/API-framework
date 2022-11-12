package cRUDOperationWithBDDApproach;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithText
{
	@Test
	public void addProjectTest()
	{
		Random ran = new Random();
		int no = ran.nextInt(2000);
	
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", null);
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
       given()
       .body(jobj)
       .contentType(ContentType.TEXT)
       
       
       .when()
       .post("http://rmgtestingserver:8084/addProject")
   
       
       .then()
       .assertThat().statusCode(201)
       .assertThat().statusLine("HTTP/1.1 201 ")
       .assertThat().contentType(ContentType.TEXT)
       .assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
       .log().all();
       
       
		
	}

}
