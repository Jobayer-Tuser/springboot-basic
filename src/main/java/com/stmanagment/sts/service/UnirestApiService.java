package com.stmanagment.sts.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Service;

@Service
public class UnirestApiService {

    private static String API_URL = "https://ollyo.atlassian.net/rest/api/3/project";
    
    public HttpResponse<JsonNode> GetUnirestApiResponse() throws UnirestException {

        HttpResponse<JsonNode> response = Unirest.get(API_URL)
            .header("Accept", "application/json")
            .header("content-type", "application/json")
            .basicAuth("nirjhor@joomshaper.com", "f24V97nmlmBsnH5reM0mD42E")
            .asJson();

            
            // retrieve the parsed JSONObject from the response
            // JSONObject myObj = response.getBody().getObject();
             

            // extract fields from the object
            // String msg = myObj.getString("error_message");
            // JSONArray results = myObj.getJSONArray();
        return response;
    }

}
