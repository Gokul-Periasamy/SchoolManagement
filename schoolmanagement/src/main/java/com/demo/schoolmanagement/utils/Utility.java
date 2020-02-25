package com.demo.schoolmanagement.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {
	
	 private static Logger logger = LoggerFactory.getLogger(Utility.class);
	
	
	public static JSONObject convertJsonStringToJsonObject(String jsonString) {
        JSONParser parser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            logger.error("Error while parsing json string");
            e.printStackTrace();
        }

        return object;
    }

}
