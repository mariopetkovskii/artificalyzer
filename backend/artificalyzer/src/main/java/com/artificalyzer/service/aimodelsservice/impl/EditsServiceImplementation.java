package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.helperfunction.HelperFunction;
import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.edits.EditsHelper;
import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.EditsRepository;
import com.artificalyzer.repository.relationsrepository.EditsUserRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.EditsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EditsServiceImplementation implements EditsService {
    private EditsRepository editsRepository;
    private EditsUserRepository editsUserRepository;
    private UserRepository userRepository;
    @Override
    public Optional<Edits> addEditsModel(EditsHelper editsHelper, String authHeader) throws JsonProcessingException {
        Edits edits = new Edits();
        edits.setModel("text-davinci-edit-001");
        edits.setInputText(editsHelper.getInputText());
        edits.setInstruction(editsHelper.getInstruction());
        edits.setOutputText(AiModelsApiCalls.outputEditsDaVinci(editsHelper.getInputText(), editsHelper.getInstruction()));
        String email = HelperFunction.decodeJwtToGetEmail(authHeader);
        User user = this.userRepository.findByEmail(email);
        this.editsUserRepository.save(new EditsUser(user, edits));
        return Optional.of(this.editsRepository.save(edits));
    }
}
