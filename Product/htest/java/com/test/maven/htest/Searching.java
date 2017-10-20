package com.test.maven.htest;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import net.miginfocom.swing.MigLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
public class Searching extends JPanel   implements ActionListener {
    protected JTextField searchBox;
    protected JTextArea textArea;
    	public Searching() {
    		searchBox = new JTextField();
    		add(searchBox, "cell 12 1,alignx center");
    		searchBox.setColumns(10);
    		searchBox.addActionListener(this);
    	}

    	public void actionPerformed(ActionEvent e) {    		
    		    String text = searchBox.getText();
    		  
    		    System.out.println(text);
try {
	int i=0;
while (findb(text).optJSONObject(i) != null){
					System.out.println(findb(text).getJSONObject(i).toString());
i++;
}
				} catch (ParseException e1) {
				
					e1.printStackTrace();
				}
    		}
    		
    	
    	public static JSONArray findb(String cardName) throws ParseException {
    		HttpResponse<JsonNode> response = null;
    		try {
    			// These code snippets use an open-source library. http://unirest.io/java
    		response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/" + cardName + "?collectible=1")
    			.header("X-Mashape-Key", "tL8NdfGtrEmshv1RnDLl4zqeFOAPp161yNYjsnQENIXk0HPFoE")
    			.asJson();
    		} catch (UnirestException e) {

    			e.printStackTrace();
    		}
    		JSONObject cardNames = new JSONObject();
    		JSONArray aCardNames= new JSONArray();
    	
    		if (response != null) {
    			cardNames = new JSONObject(response.getBody());
    			aCardNames = cardNames.getJSONArray("array");
    			
    			
    			
    		}
    		return aCardNames;
    }
}