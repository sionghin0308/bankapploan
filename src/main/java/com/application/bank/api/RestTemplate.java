package com.application.bank.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTemplate {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	protected ResponseEntity<Map<String, Object>> buildSuccessResponse(boolean respond, String entity, Object result) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", respond);
		map.put(entity, result);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	protected ResponseEntity<Map<String, Object>> buildFailedResponse(boolean respond, String errMsg) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", respond);
		map.put("message", errMsg);
		return buildFailedResponse(map);
	}
	
	protected ResponseEntity<Map<String, Object>> buildFailedResponse(Object result) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", mapper.convertValue(result, Map.class));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
