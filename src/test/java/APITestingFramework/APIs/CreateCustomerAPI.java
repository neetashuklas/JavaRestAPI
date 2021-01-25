package APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFrameworkSetUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	public static Response sendPostRequesttoCreateCustomerAPIWithValidAuthKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("ValidSecretKey"), "")
				.formParam("name", data.get("name")).formParam("email", data.get("email"))
				.formParam("description", data.get("description")).post(config.getProperty("CustomerAPIEndpoint"));

		return response;

	}

	public static Response sendPostRequesttoCreateCustomerAPIWithInValidAuthKey(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("InValidSecretKey"), "")
				.formParam("name", data.get("name")).formParam("email", data.get("email"))
				.formParam("description", data.get("description")).post(config.getProperty("CustomerAPIEndpoint"));

		return response;

	}
}
