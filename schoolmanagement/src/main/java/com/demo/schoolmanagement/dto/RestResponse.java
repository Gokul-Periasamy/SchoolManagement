package com.demo.schoolmanagement.dto;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {

	    private String message;
	    private Object data;

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }


	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

	    public void setData(String key, Object data) {
	        Map<String, Object> val = new HashMap<>();
	        val.put(key, data);
	        this.data = val;
	    }
	}


