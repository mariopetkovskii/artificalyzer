package com.artificalyzer.helperfunction;

import com.artificalyzer.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import static com.artificalyzer.security.SecurityConstants.SECRET;

public class HelperFunction {
    public static String decodeJwtToGetEmail(String jwtToken){
        String token = jwtToken.substring(7); // remove "Bearer " prefix
        String email = null;


        try {
            email = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();;
        } catch (JWTVerificationException e) {
            // handle verification exception
        }
        return email;
    }
}
