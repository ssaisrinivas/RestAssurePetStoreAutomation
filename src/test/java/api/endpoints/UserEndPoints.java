package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
// Created for performing create , update ,retrieve ,delete operations on the user API.

public class UserEndPoints {
	
//POST	
public static Response createUser(User payload) {
	
Response response	=given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	.when()
	.post(Routes.post_url);

return response;
}


//GET
public static Response readUser(String userName) {

Response response	=given()
.pathParam("userName", userName)

.when()
.get(Routes.get_url);

return response;
}

//PUT
public static Response updateUser(String userName ,User payload) {
	
Response response = given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	.pathParam("userName", userName)
	.when()
	.put(Routes.put_url);

return response;
}

//DELETE
public static Response deleteUser(String userName) {

Response response	=given()
.pathParam("userName", userName)

.when()
.delete(Routes.delete_url);

return response;
}


}
