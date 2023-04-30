package com.artificalyzer.xcontrollers.aimodelscontrollers;

import com.artificalyzer.models.aimodels.edits.Edits;
import com.artificalyzer.models.aimodels.edits.EditsHelper;
import com.artificalyzer.service.aimodelsservice.interfaces.EditsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/aimodels/edits")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class EditsController {
    private EditsService editsService;

    @PostMapping("/post")
    public ResponseEntity<Edits> edits(@RequestBody EditsHelper editsHelper,
                                       @RequestHeader("Authorization") String authorizationHeader) throws JsonProcessingException {
        return this.editsService.addEditsModel(editsHelper, authorizationHeader)
                .map(edits -> ResponseEntity.ok().body(edits))
                .orElseGet(() -> ResponseEntity.ok().build());
    }
}
