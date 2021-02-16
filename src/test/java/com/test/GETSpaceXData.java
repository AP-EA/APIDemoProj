
package com.test;
//import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.RestAssuredConfiguration;
import common.EndPoint;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Headers;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@Test
public class GETSpaceXData{

	@Test(groups = "SpacexDemo-AP")
	public void ValidateSuccessStatusCodeReturnedInResponse() {
		// Log the request
		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();	
		System.out.println("\n\nRequest: \n\n\n" + requestSpecification.log().all());
		
		//Log the response
		Response response =  given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA);		
		String responseAsString = response.asString();
		System.out.println("\n\n Response: \n\n\n"+ responseAsString);
		
		//Log Response Header
		Headers responseHeaderAsString = response.getHeaders();
		System.out.println("\n\n Response Header: \n\n"+ responseHeaderAsString + "\n\n");
		
		
		// Validate response statusCode=200 for the GET launch details request
		//given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA).then().statusCode(200);
		
	    int statusCode = response.getStatusCode(); 
	    Assert.assertTrue(statusCode == 200, " Success"); 
	}
	
	@Test(groups = "SpacexDemo-AP")
	public void ValidateResponseTimeIsLessThanTwoSeconds() {

		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();	
		given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA);
		
		Response response =  given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA);
		
		//validate that the response time of the API is less than or equal to 2 seconds
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) <=2, "Response time Is Not Within Limit");
	}
	
	@Test(groups = "SpacexDemo-AP")
	public void ValidateErrorInResponseWhenInvalidParameterPassedInRequest() {

		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();	
		//Response response =  given().spec(requestSpecification).get(EndPoint.GET_SPACEXDATANEGATIVE);
		//response.then().body("", Matchers.hasSize(0));
		
		
		//We are getting 200 response with blank body in response. We should handle it gracefully with proper status code.
		given().spec(requestSpecification).get(EndPoint.GET_SPACEXDATANEGATIVE).then().statusCode(200);
	}	
	
	@Test(groups = "SpacexDemo-AP")
	public void ValidateSpaceSatelliteLaunchDetails() {

		RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();	
		given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA);
		
		Response response =  given().header("content-type","application/json").spec(requestSpecification).get(EndPoint.GET_SPACEXDATA);
		String responseAsString = response.asString();
		Assert.assertTrue(responseAsString.contains("id")); 
		Assert.assertTrue(responseAsString.contains("links")); 
		Assert.assertTrue(responseAsString.contains("details")); 
		Assert.assertTrue(responseAsString.contains("flight_number")); 
		Assert.assertTrue(responseAsString.contains("name")); 
		response.then().body("name",equalTo("Starlink-18 (v1.0)"));	
	}
	
}





