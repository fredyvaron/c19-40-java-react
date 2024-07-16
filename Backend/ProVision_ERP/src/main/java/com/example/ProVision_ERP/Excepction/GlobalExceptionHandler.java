package com.example.ProVision_ERP.Excepction;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException (Exception exception) {
        ProblemDetail errorDetail = null;
        exception.printStackTrace();

        if (exception instanceof BadCredentialsException ) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
            errorDetail.setProperty("Descripcion", "The username or password is incorrect");
            return errorDetail;
        }
        if (exception instanceof AccountStatusException ){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descripction", "The Count Is Locked");
            return errorDetail;
        }
        if (exception instanceof AccessDeniedException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descrpction", "Your are not authorized to acces this resources");
        }
        if ( exception instanceof SignatureException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descripction", "The JWT Signature is invalid");
        }
        if( exception instanceof ExpiredJwtException ) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
            errorDetail.setProperty("Descripction", "The JWT Has Expired");
        }
        if( errorDetail  == null ) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
            errorDetail.setProperty("Descripction", "Unknown internal server error.");
        }

        return errorDetail;
    }

    
}
