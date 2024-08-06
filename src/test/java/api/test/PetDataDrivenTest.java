package api.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import api.utilities.DataProviders;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

@Listeners(ExtentReportManager.class)
public class PetDataDrivenTest {
	Pet petPayload;

	// POST
	@Test(priority = 1, dataProvider = "PetData", dataProviderClass = DataProviders.class)

	public void testPostPetData(String petId, String categoryId, String categoryName, String AnimalName,
			String photoUrls, String TagId, String TagName, String status) {
		petPayload = new Pet();

		petPayload.setId(Integer.parseInt(petId));

		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));
		category.setName(categoryName);
		petPayload.setCategory(category);

		petPayload.setName(AnimalName);

		String[] myArray = photoUrls.split(", ");
		List<String> photoUrlList = Arrays.asList(myArray);
		petPayload.setPhotoUrls(photoUrlList);

		Tags tags1 = new Tags();
		tags1.setId(Integer.parseInt(TagId));
		tags1.setName(TagName);

		List<Tags> tagsList = new ArrayList<Tags>();
		tagsList.add(tags1);

		petPayload.setTags(tagsList);
		petPayload.setStatus(status);

		Response response = PetEndPoints.createPets(petPayload);
		assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
	}

//GET
	@Test(priority = 2, dataProvider = "PetId", dataProviderClass = DataProviders.class,dependsOnMethods = "testPostPetData")
	void testGetPetById(String petId) {

		Response response = PetEndPoints.readPets(Integer.parseInt(petId));
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);

	}

	// DELETE
	@Test(priority = 3, dataProvider = "PetId", dataProviderClass = DataProviders.class,dependsOnMethods = "testGetPetById")

	public void testDeletePetById(String petId) {

		Response response = PetEndPoints.deletePets(Integer.parseInt(petId));
		assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
	}

}
