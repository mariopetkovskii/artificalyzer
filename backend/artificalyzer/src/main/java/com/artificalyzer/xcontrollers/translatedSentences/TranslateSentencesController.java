package com.artificalyzer.xcontrollers.translatedSentences;

import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.models.aimodels.relations.TranslateSentenceUsers;
import com.artificalyzer.service.relationsservice.interfaces.TranslateUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TranslateSentencesController {
    private final TranslateUserService translateUserService;
    @GetMapping("/get")
    public Page<TranslateSentenceUsers> getAllEditsUser(@RequestHeader("Authorization") String authorizationHeader,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "1") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy){
        return this.translateUserService.findAllbyUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
