package com.artificalyzer.port;

import com.artificalyzer.models.aimodels.edits.EditsDto;
import com.artificalyzer.models.aimodels.moderations.Moderation;
import com.artificalyzer.models.aimodels.moderations.ModerationDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AiModelsApiCalls {
    static RestTemplate restTemplate = new RestTemplate();
    public static String outputEditsDaVinci(String input, String instruction) throws JsonProcessingException {
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
        ResponseEntity<EditsDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, EditsDto.class);
        return Objects.requireNonNull(response.getBody()).getChoices().get(0).getText();
    }

    public static ModerationDto outputModerationModel(String input) throws JsonProcessingException {
        String url = "https://api.openai.com/v1/moderations";
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setBearerAuth("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");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> data = new HashMap<>();
        data.put("input", input);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);
        HttpEntity<String> entity = new HttpEntity<>(json, httpHeaders);
        ResponseEntity<ModerationDto> response = restTemplate.exchange(url, HttpMethod.POST, entity, ModerationDto.class);
        return response.getBody();
    }

}
