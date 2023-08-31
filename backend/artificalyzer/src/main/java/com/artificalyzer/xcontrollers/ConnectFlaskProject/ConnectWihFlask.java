package com.artificalyzer.xcontrollers.ConnectFlaskProject;

import com.artificalyzer.models.aimodels.sentiment_analysis.SentmentAnalysisHelper;
import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentenceHelper;
import com.artificalyzer.models.userroles.helpers.SentenceTranslate;
import com.artificalyzer.service.aimodelsservice.interfaces.SentimentAnalysisService;
import com.artificalyzer.service.aimodelsservice.interfaces.TranslateSentenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/rest/model/sentence")
@CrossOrigin("http://localhost:4200/")
@AllArgsConstructor
public class ConnectWihFlask {
    private final SentimentAnalysisService sentimentAnalysisService;
    private final TranslateSentenceService translateSentenceService;
    @PostMapping("/translate_sentence")
    public String translate_sentence(@RequestBody SentenceTranslate sentenceTranslate,
                                     @RequestHeader("Authorization") String authorizationHeader){
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
        try {
            Map<String, Object> jsonResponse = new ObjectMapper().readValue(response, Map.class);
            String translateSentence = (String) jsonResponse.get("translated");
            TranslateSentenceHelper translateSentenceHelper = new TranslateSentenceHelper();
            translateSentenceHelper.setInput_sentance(sentence);
            translateSentenceHelper.setLg(language);
            translateSentenceHelper.setTranslated_sentece(translateSentence);
            translateSentenceService.saveTranslateSentenceModel(translateSentenceHelper, authorizationHeader );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
        return response;
    }
    @PostMapping("/analysis")
    public String analysis(@RequestBody Map<String, Object> json,
                           @RequestHeader("Authorization") String authorizationHeader){

        String sentence=(String)json.get("sentence");
        System.out.println(sentence);
        String url = "http://localhost:5000/analysis";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, json, String.class);
        try {
            Map<String, Object> jsonResponse = new ObjectMapper().readValue(response, Map.class);
            String polarity = (String) jsonResponse.get("polarity");
            SentmentAnalysisHelper sentmentAnalysisHelper = new SentmentAnalysisHelper();
            sentmentAnalysisHelper.setInput_sentance(sentence);
            sentmentAnalysisHelper.setPolarity(polarity);
            sentimentAnalysisService.saveSentimentAnalysisModel(sentmentAnalysisHelper, authorizationHeader );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
        return response;
    }
}
