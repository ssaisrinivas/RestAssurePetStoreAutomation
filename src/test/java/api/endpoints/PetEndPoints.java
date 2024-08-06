package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//PetEndPoints.java
// Created for performing create , update ,retrieve ,delete operations on the pet API.

public class PetEndPoints {
		
	//POST	
	public static Response createPets(Pet payload) {
		
	Response response	=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_pet_url);

	return response;
	}


	//GET
	public static Response readPets(int petId) {

	Response response	=given()
	.pathParam("petId", petId)

	.when()
	.get(Routes.get_pet_url);

	return response;
	}

	//PUT
	public static Response updatePets(Pet payload) {
		
	Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)		
		.when()
		.put(Routes.put_pet_url);

	return response;
	}

	//DELETE
	public static Response deletePets(int petId) {

	Response response	=given()
	.pathParam("petId", petId)

	.when()
	.delete(Routes.delete_pet_url);
	return response;
	}





}
