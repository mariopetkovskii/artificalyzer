package com.artificalyzer.xcontrollers.translatedSentences;

import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.models.aimodels.relations.TranslateSentenceUsers;
import com.artificalyzer.service.relationsservice.interfaces.TranslateUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/models/all_translated_sentences")
@AllArgsConstructor
public class TranslateSentencesController {
    private final TranslateUserService translateUserService;
    @GetMapping("/get")
    public Page<TranslateSentenceUsers> getAllTranslatedSentencesUser(@RequestHeader("Authorization") String authorizationHeader,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "1") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy){
        return this.translateUserService.findAllbyUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
