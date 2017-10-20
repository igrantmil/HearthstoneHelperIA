package com.test.maven.htest;
import java.text.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.kopitubruk.util.json.*;
import org.kopitubruk.util.json.JSONParser;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	try {
    		HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards?collectible=1")
    				.header("X-Mashape-Key", "tL8NdfGtrEmshv1RnDLl4zqeFOAPp161yNYjsnQENIXk0HPFoE")
    				.asJson();
    		
    		JSONObject test= new JSONObject(response);
    		JSONArray atest = new JSONArray("[Basic]");
    		
				
				
		
				
			
    	
		
		
		
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	

    }
}
