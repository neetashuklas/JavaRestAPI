package com.w2a.APITestingFrameworkTestCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFrameworkSetUp.BaseTest;

import APITestingFramework.APIs.CreateCustomerAPI;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequesttoCreateCustomerAPIWithValidAuthKey(data);
		// ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void InvalidateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.sendPostRequesttoCreateCustomerAPIWithInValidAuthKey(data);
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

}