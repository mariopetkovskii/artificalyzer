package com.artificalyzer.xcontrollers.relationscontrollers;

import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.service.relationsservice.interfaces.ImagesUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/models/imagesuser")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class ImagesUserController {
    private final ImagesUserService imagesUserService;
    @GetMapping("/get")
    public List<ImagesUser> getAllEditsUser(@RequestHeader("Authorization") String authorizationHeader){
        return this.imagesUserService.findAllByUser(authorizationHeader);
    }
}
