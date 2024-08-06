package api.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;



@Listeners(ExtentReportManager.class)
public class PetTests {

	Faker faker;
	Pet petPayload;
	public Logger logger; // for logs

	@BeforeClass
	public void setupData() {

		faker = new Faker();
		petPayload = new Pet();
		petPayload.setId(faker.idNumber().hashCode());

		Category category = new Category();
		category.setId(faker.idNumber().hashCode());
		category.setName(faker.animal().name());
		petPayload.setCategory(category);

		petPayload.setName(faker.animal().name());

		List<String> photoUrls = new ArrayList<String>();
		photoUrls.add(faker.university().name());
		photoUrls.add(faker.university().name());
		photoUrls.add(faker.university().name());

		petPayload.setPhotoUrls(photoUrls);

		Tags tags1 = new Tags();
		tags1.setId(faker.idNumber().hashCode());
		tags1.setName(faker.name().firstName());

		Tags tags2 = new Tags();
		tags2.setId(faker.idNumber().hashCode());
		tags2.setName(faker.name().firstName());

		List<Tags> tagsList = new ArrayList<Tags>();
		tagsList.add(tags1);
		tagsList.add(tags2);
		petPayload.setTags(tagsList);

		petPayload.setStatus("Alive");
		
		//logs 
		logger= LogManager.getLogger(this.getClass());
		
		
	}

	// POST
	@Test(priority = 1)
	void testPostPet() {
      logger.info("************ Create Pet ***********************");
		Response response = PetEndPoints.createPets(petPayload);

		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		
		logger.info("************ Pet created Successfully ***********************");
	}

	// GET
	@Test(priority = 2)
	void testGetPetById() {
		
		logger.info("************ Reading Pet ***********************");

		Response response = PetEndPoints.readPets(petPayload.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		
		logger.info("************ Pet in info trace displayed ***********************");

	}

	// PUT
	@Test(priority = 3)
	void testUpdateUserByName() {
		logger.info("************ Updating Pet ***********************");
		Faker faker1 = new Faker();
		petPayload.setName(faker1.animal().name());

		List<String> photoUrls1 = new ArrayList<String>();
		photoUrls1.add(faker1.university().name());
		photoUrls1.add(faker1.university().name());
		photoUrls1.add(faker1.university().name());

		Response response = PetEndPoints.updatePets(petPayload);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);

		// Checking after update

		Response responseAfterUpdate = PetEndPoints.readPets(petPayload.getId());
		assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		
		logger.info("************ Pet data Updated Successfully ***********************");

	}

	// DELETE
	@Test(priority = 4)
	void testDeleteUserByName() {
		
		logger.info("************ Deleting Pet ***********************");

		Response response = PetEndPoints.deletePets(petPayload.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		
		logger.info("************ Pet deleted Successfully ***********************");

	}

}
