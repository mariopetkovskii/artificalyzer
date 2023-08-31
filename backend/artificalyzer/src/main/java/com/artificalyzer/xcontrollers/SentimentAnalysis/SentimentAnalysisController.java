package com.artificalyzer.xcontrollers.SentimentAnalysis;

import com.artificalyzer.models.aimodels.relations.SentimentAnalysisUsers;
import com.artificalyzer.service.relationsservice.interfaces.SentimentUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/models/all_sentiment_analysis")
@AllArgsConstructor
public class SentimentAnalysisController {
    private final SentimentUserService sentimentUserService;
    @GetMapping("/get")
    public Page<SentimentAnalysisUsers> getAllSentimentAnalysisUser(@RequestHeader("Authorization") String authorizationHeader,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "1") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy){
        return this.sentimentUserService.findAllbyUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
