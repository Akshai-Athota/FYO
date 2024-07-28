package com.akshai.FYO.Service.Impl;

import com.akshai.FYO.Service.CurrentLocationServiceInterface;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrentLocationService implements CurrentLocationServiceInterface {

    public static final String Location_Api_URL = "https://ipapi.co/{ip}/json/";
    @Override
    public String getPersonIp(HttpServletRequest request) {
        String remoteIp="";
        if(request != null){
            remoteIp =request.getHeader("X-FORWARDED-FOR");
            if(remoteIp == null || remoteIp.isEmpty()){
                remoteIp = request.getRemoteAddr();
            }
        }
        return remoteIp;
    }

    @Override
    public JsonNode getCurrentLocation(String ip) throws IOException {
        String url=Location_Api_URL.replace("{ip}",ip);
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet request = new HttpGet(url);
            try(CloseableHttpResponse response=httpClient.execute(request)){
                String jsonResponse = EntityUtils.toString(response.getEntity());
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readTree(jsonResponse);
            }
        }
    }
}
