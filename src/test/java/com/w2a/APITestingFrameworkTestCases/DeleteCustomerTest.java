package com.w2a.APITestingFrameworkTestCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFramework.utilities.TestUtils;
import com.w2a.APITestingFrameworkSetUp.BaseTest;

import APITestingFramework.APIs.DeleteCustomerAPI;
import Listener.ExtentListeners;
import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequesttoDeleteCustomerAPIWithValidId(data);
		ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();
		System.out.println(response.getStatusCode());
	

		Assert.assertTrue(TestUtils.JsonhasKey(response.asString(), "id"), "Id key is not present");

		String actual_id = TestUtils.getJasonKeyValue(response.asString(), "id");
		System.out.println("Actual id is :: " + actual_id);

		Assert.assertEquals(actual_id, data.get("id"));
		System.out.println("Object key value is:: " + TestUtils.getJasonKeyValue(response.asString(), "object"));
		System.out.println("Deleted key value is:: " + TestUtils.getJasonKeyValue(response.asString(), "deleted"));

		Assert.assertEquals(response.statusCode(), 200);
	}

}