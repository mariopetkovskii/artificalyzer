package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.relations.TranslateSentenceUsers;
import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentence;
import com.artificalyzer.models.aimodels.translate_sentence.TranslateSentenceHelper;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.repository.aimodelsrepository.TranslateSentenceRepository;
import com.artificalyzer.repository.relationsrepository.TranslateSentenceUsersRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.TranslateSentenceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TranslateServiceImpl implements TranslateSentenceService {
    private final UserRepository userRepository;
    private final TranslateSentenceUsersRepository translateSentenceUsersRepository;
    private final TranslateSentenceRepository translateSentenceRepository;
    @Override
    public Optional<TranslateSentence> saveTranslateSentenceModel(TranslateSentenceHelper translateSentenceHelper, String authHeader) throws JsonProcessingException {
        TranslateSentence translateSentence = new TranslateSentence();
        translateSentence.setInput_sentance(translateSentenceHelper.getInput_sentance());
        translateSentence.setLg(translateSentenceHelper.getLg());
        translateSentence.setTranslated_sentece(translateSentenceHelper.getTranslated_sentece());
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        this.translateSentenceUsersRepository.save(new TranslateSentenceUsers(user, translateSentence));
        return Optional.of(this.translateSentenceRepository.save(translateSentence));
    }
}
