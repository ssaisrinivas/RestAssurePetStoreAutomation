package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPointsFromProperty;
import api.payload.User;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

@Listeners(ExtentReportManager.class)
public class UserTestsfromProperty {

	Faker faker;
	User userPayload;
	@BeforeClass
	public void setupData() {
		 
	faker = new Faker();
	userPayload = new User();
	
	userPayload.setId(faker.idNumber().hashCode());	
	userPayload.setUserName(faker.name().username());	
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().emailAddress());
	userPayload.setPassword(faker.internet().password());
	userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	
	System.out.println(userPayload.getUserName());
	}
	
	
	@Test(priority=1)
	void testPostUser(){
		
	Response response =	UserEndPointsFromProperty.createUser(userPayload);
	
	response.then().log().all();
	assertEquals(response.getStatusCode(), 200);	
	}
	
	
	@Test(priority=2)
	void testGetUserByName(){
		
		
	Response response = UserEndPointsFromProperty.readUser(userPayload.getUserName());		
	response.then().log().all();
	assertEquals(response.getStatusCode(), 404);
	
	}
	
	
	@Test(priority=3)
	void testUpdateUserByName(){
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
	Response response = UserEndPointsFromProperty.updateUser(userPayload.getUserName(),userPayload);		
	response.then().log().all();
	assertEquals(response.getStatusCode(), 200);
	
	//Checking after update
	
	Response responseAfterUpdate = UserEndPointsFromProperty.readUser(userPayload.getUserName());
	assertEquals(responseAfterUpdate.getStatusCode(), 200);
	
	}
	

	@Test(priority=4)
	void testDeleteUserByName(){
				
	Response response = UserEndPointsFromProperty.deleteUser(userPayload.getUserName());		
	response.then().log().all();
	assertEquals(response.getStatusCode(), 404);
	
	}
}
