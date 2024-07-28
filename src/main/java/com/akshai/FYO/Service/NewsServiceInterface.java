package com.akshai.FYO.Service;

import com.fasterxml.jackson.databind.JsonNode;

public interface NewsServiceInterface {
    JsonNode getNews(String location);
}
