package com.artificalyzer.service.aimodelsservice.impl;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.edits.EditsHelper;
import com.artificalyzer.port.AiModelsApiCalls;
import com.artificalyzer.repository.aimodelsrepository.EditsRepository;
import com.artificalyzer.service.aimodelsservice.interfaces.EditsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EditsServiceImplementation implements EditsService {
    private EditsRepository editsRepository;
    @Override
    public Optional<Edits> addEditsModel(EditsHelper editsHelper) throws JsonProcessingException {
        Edits edits = new Edits();
        edits.setModel("text-davinci-edit-001");
        edits.setInputText(editsHelper.getInputText());
        edits.setInstruction(editsHelper.getInstruction());
        edits.setOutputText(AiModelsApiCalls.outputEditsDaVinci(editsHelper.getInputText(), editsHelper.getInstruction()));
        return Optional.of(this.editsRepository.save(edits));
    }
}
