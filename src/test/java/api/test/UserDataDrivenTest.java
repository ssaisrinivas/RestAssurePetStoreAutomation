package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

@Listeners(ExtentReportManager.class)
public class UserDataDrivenTest {
	
	@Test(priority=0,dataProvider="UserData",dataProviderClass=DataProviders.class)
	
	public void testPostData(String userId,String userName,String firstName,String lastName,String useremail,String pwd,String phoneN) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));	
		userPayload.setUserName(userName);	
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phoneN);
		
		Response response =	UserEndPoints.createUser(userPayload);		
		assertEquals(response.getStatusCode(), 200);	
	}
	
	
	@Test(priority=0,dataProvider="UserName",dataProviderClass=DataProviders.class)
	
	public void testDeleteUserByName(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);				
		assertEquals(response.getStatusCode(), 200);
	}
	
	

}
