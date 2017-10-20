package com.test.maven.htest;

import java.text.ParseException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Scanner;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class App {
	public static void main(String[] args) throws ParseException {
		System.out.println(findb("Ysera").toString());

	}

	public static void find(String a) throws ParseException {
		try {
			HttpResponse<JsonNode> response = Unirest
					.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards?collectible=1")
					.header("X-Mashape-Key", "tL8NdfGtrEmshv1RnDLl4zqeFOAPp161yNYjsnQENIXk0HPFoE").asJson();
			// collectable cards hashmap ids= 2043-2077
			JSONObject test = new JSONObject(response.getBody());
			JSONArray atest = test.getJSONArray("array");
			JSONObject o = new JSONObject();
			o = atest.getJSONObject(0);
			Iterator<?> keys = o.keys();
			JSONObject value = new JSONObject();
			while (keys.hasNext()) {
				String key = keys.next().toString();
				JSONArray set = o.getJSONArray(key);
				for (int i = 0; i < set.length(); i++) {
					value = set.getJSONObject(i);
					if (value.get("name") != null) {
						if (value.get("name").toString().toLowerCase().contains(a.toLowerCase()))
							System.out.println(value.get("name").toString());
					}
				}
			}
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static JSONArray getCards() {
		HttpResponse<JsonNode> response = null;
		try {
			response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards?collectible=1")
					.header("X-Mashape-Key", "tL8NdfGtrEmshv1RnDLl4zqeFOAPp161yNYjsnQENIXk0HPFoE").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// collectable cards hashmap ids= 2043-2077
		JSONObject test = new JSONObject(response.getBody());
		JSONArray atest = test.getJSONArray("array");
		JSONObject o = new JSONObject();
		o = atest.getJSONObject(0);
		JSONArray total = new JSONArray();
		int i = 0;
		Iterator<?> keys = o.keys();
		JSONObject value = new JSONObject();
		while (keys.hasNext()) {
			String key = keys.next().toString();
			JSONArray set = o.getJSONArray(key);
			total = set.getJSONArray(i);
			i++;

		}
		return total;
	}

	public static JSONArray findb(String cardName) throws ParseException {
		HttpResponse<JsonNode> response = null;
		try {
			// These code snippets use an open-source library.
			// http://unirest.io/java
			response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/rock?collectible=1")
					.header("X-Mashape-Key", "tL8NdfGtrEmshv1RnDLl4zqeFOAPp161yNYjsnQENIXk0HPFoE").asJson();
		} catch (UnirestException e) {

			e.printStackTrace();
		}
		JSONObject cardNames = new JSONObject();
		JSONArray aCardNames = new JSONArray();
		if (response != null) {
			cardNames = new JSONObject(response.getBody());
			aCardNames = cardNames.getJSONArray("array");
		}
		return aCardNames;
	}
}