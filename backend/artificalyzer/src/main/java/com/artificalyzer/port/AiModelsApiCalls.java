package com.artificalyzer.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class AiModelsApiCalls {

    public static String outputEditsDaVinci(String input, String instruction) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.openai.com/v1/edits";
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setBearerAuth("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");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> data = new HashMap<>();
        data.put("model", "text-davinci-edit-001");
        data.put("input", input);
        data.put("instruction", instruction);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);
        HttpEntity<String> entity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return "test";
    }

}
