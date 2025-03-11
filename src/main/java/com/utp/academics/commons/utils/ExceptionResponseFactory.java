package com.utp.academics.commons.utils;

import com.utp.academics.commons.presentaton.dtos.ExceptionResponse;
import com.utp.academics.commons.presentaton.dtos.NotValidField;
import com.utp.academics.commons.presentaton.dtos.NotValidFieldsResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExceptionResponseFactory {
    public ResponseEntity<ExceptionResponse> createErrorResponse(
        HttpStatus httpStatus,
        HttpServletRequest httpServletRequest,
        String message
    ) {
        ExceptionResponse response = ExceptionResponse.builder()
            .path(httpServletRequest.getRequestURI())
            .method(httpServletRequest.getMethod())
            .statusCode(httpStatus.value())
            .statusDescription(httpStatus.name())
            .message(message)
            .build();
        return ResponseEntity.status(httpStatus).body(response);
    }
    public ResponseEntity<NotValidFieldsResponse> createValidationErrorResponse(
        HttpStatus httpStatus,
        HttpServletRequest httpServletRequest,
        List<NotValidField> notValidFields
    ) {
        NotValidFieldsResponse response = NotValidFieldsResponse.builder()
            .path(httpServletRequest.getRequestURI())
            .method(httpServletRequest.getMethod())
            .statusCode(httpStatus.value())
            .statusDescription(httpStatus.name())
            .notValidFields(notValidFields)
            .build();
        return ResponseEntity.status(httpStatus).body(response);
    }
}
