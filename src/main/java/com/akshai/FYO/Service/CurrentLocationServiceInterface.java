package com.akshai.FYO.Service;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface CurrentLocationServiceInterface {
    String getPersonIp(HttpServletRequest request);
    JsonNode getCurrentLocation(String ip) throws IOException;
}
