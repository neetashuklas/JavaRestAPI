package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

import Listener.ExtentListeners;

public class TestUtils {
	public static boolean JsonhasKey(String Json, String key) {
		JSONObject jsonObject = new JSONObject(Json);
		ExtentListeners.testReport.get().info("Validating the presence of Key::" + key);
		return jsonObject.has(key);

	}

	public static String getJasonKeyValue(String Json, String key) {

		JSONObject jsonObject = new JSONObject(Json);
		ExtentListeners.testReport.get().info("Validating the value of the key::" + key);
		return jsonObject.get(key).toString();

	}
}
