package com.artificalyzer.xcontrollers.relationscontrollers;

import com.artificalyzer.models.aimodels.relations.EditsUser;
import com.artificalyzer.security.SecurityConstants;
import com.artificalyzer.service.relationsservice.interfaces.EditsUserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/models/editsuser")
@CrossOrigin("http://localhost:3000/")
@AllArgsConstructor
public class EditsUserController {
    private final EditsUserService editsUserService;

    @GetMapping("/get")
    public Page<EditsUser> getAllEditsUser(@RequestHeader("Authorization") String authorizationHeader,
                                           @RequestParam(defaultValue = "0") Integer pageNo,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(defaultValue = "id") String sortBy){
        return this.editsUserService.findAllByUser(authorizationHeader, pageNo, pageSize, sortBy);
    }
}
