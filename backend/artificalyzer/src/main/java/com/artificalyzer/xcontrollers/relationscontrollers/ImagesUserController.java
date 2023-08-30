package com.artificalyzer.xcontrollers.relationscontrollers;

import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.models.aimodels.relations.ImagesUser;
import com.artificalyzer.service.relationsservice.interfaces.ImagesUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/models/imagesuser")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class ImagesUserController {
    private final ImagesUserService imagesUserService;
    @GetMapping("/get")
    public Page<ImagesUser> getAllEditsUser(@RequestHeader("Authorization") String authorizationHeader,
                                            @RequestParam(defaultValue = "0") Integer pageNo,
                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                            @RequestParam(defaultValue = "id") String sortBy){
        return this.imagesUserService.findAllByUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
