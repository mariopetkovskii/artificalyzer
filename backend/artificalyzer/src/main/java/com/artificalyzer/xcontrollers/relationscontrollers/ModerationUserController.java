package com.artificalyzer.xcontrollers.relationscontrollers;

import com.artificalyzer.models.aimodels.relations.ModerationUser;
import com.artificalyzer.service.relationsservice.interfaces.ModerationUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/models/moderations")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class ModerationUserController {
    private final ModerationUserService moderationUserService;
    @GetMapping("/get")
    public Page<ModerationUser> getAllEditsUser(@RequestHeader("Authorization") String authorizationHeader,
                                                @RequestParam(defaultValue = "0") Integer pageNo,
                                                @RequestParam(defaultValue = "1") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy){
        return this.moderationUserService.findAllByUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
