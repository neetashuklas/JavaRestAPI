package APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFrameworkSetUp.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDeleteRequesttoDeleteCustomerAPIWithValidId(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("ValidSecretKey"), "")

				.delete(config.getProperty("CustomerAPIEndpoint") + "/" + data.get("id"));

		return response;

	}
}
