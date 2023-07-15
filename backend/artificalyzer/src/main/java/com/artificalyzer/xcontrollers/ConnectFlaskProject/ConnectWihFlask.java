package com.artificalyzer.xcontrollers.ConnectFlaskProject;

import com.artificalyzer.models.userroles.helpers.SentenceTranslate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Properties;

import java.util.Map;

@RestController
@RequestMapping("/rest/model/sentence")
@CrossOrigin("http://localhost:4200/")
@AllArgsConstructor
public class ConnectWihFlask {
    @PostMapping("/translate_sentence")
    public String translate_sentence(@RequestBody SentenceTranslate sentenceTranslate){
        String sentence = sentenceTranslate.getSentence();
        String language = sentenceTranslate.getLg();
        String endpoint = "http://127.0.0.1:5000/translate_sentences";
        String json = "{\"sentence\":\"" + sentence + "\",\"lg\":\"" + language + "\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        System.out.println(json);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(endpoint, request, String.class);
        System.out.println(response);
        return response;
    }
    @PostMapping("/analysis")
    public String analysis(@RequestBody Map<String, Object> json){
        String sentence=(String)json.get("sentence");
        System.out.println(sentence);
        String url = "http://localhost:5000/analysis";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, json, String.class);
        System.out.println(response);
        return response;
    }
}
