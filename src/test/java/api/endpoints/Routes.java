package api.endpoints;

/*Swagger URI -- > https://petstore.swagger.io
 * Create User (POST) : https://petstore.swagger.io/v2/user/
 * Get User (GET) : https://petstore.swagger.io/v2/user/{userName}
 * Update user (PUT) : https://petstore.swagger.io/v2/user/{userName}
 * Delete user (Delete) : https://petstore.swagger.io/v2/user/{userName} 
 * 
*/

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url=base_url+"/user/";
	public static String get_url=base_url+"/user/{userName}";
	public static String put_url=base_url+"/user/{userName}";
	public static String delete_url=base_url+"/user/{userName}";
	
	//Store model                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	
	   // here you will create Store model URL's
	
	//Pet model 
	
      // here you will create Pet model URL's
	
	public static String post_pet_url=base_url+"/pet/";
	public static String get_pet_url=base_url+"/pet/{petId}";
	public static String put_pet_url=base_url+"/pet/";
	public static String delete_pet_url=base_url+"/pet/{petId}";
}
