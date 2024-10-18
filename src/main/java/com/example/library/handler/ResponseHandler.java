package com.example.library.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(
            String message, HttpStatus status,
            Object responseObject){
        Map<String, Object> map = new HashMap<String, Object>();
        if(responseObject != null)map.put("data", responseObject);
        map.put("message", message);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map, status);
    }
}