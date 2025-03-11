package com.utp.academics.commons.presentaton.advices;

import com.utp.academics.commons.presentaton.dtos.ExceptionResponse;
import com.utp.academics.commons.presentaton.dtos.NotValidField;
import com.utp.academics.commons.presentaton.dtos.NotValidFieldsResponse;
import com.utp.academics.commons.utils.ExceptionResponseFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

@RestControllerAdvice
public class GlobalValidationAdvice {
    private final ExceptionResponseFactory exceptionResponseFactory;
    public GlobalValidationAdvice(ExceptionResponseFactory exceptionResponseFactory) {
        this.exceptionResponseFactory = exceptionResponseFactory;
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<NotValidFieldsResponse> handleConstraintViolation(
        ConstraintViolationException constraintViolationException,
        HttpServletRequest httpServletRequest
    ) {
        List<NotValidField> notValidFields = constraintViolationException.getConstraintViolations().stream()
            .map(NotValidField::new)
            .toList();
        return this.exceptionResponseFactory.createValidationErrorResponse(BAD_REQUEST, httpServletRequest, notValidFields);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NotValidFieldsResponse> handleMethodArgumentNotValid(
        MethodArgumentNotValidException methodArgumentNotValidException,
        HttpServletRequest httpServletRequest
    ) {
        List<NotValidField> notValidFields = methodArgumentNotValidException.getFieldErrors().stream()
            .map(NotValidField::new)
            .toList();
        return this.exceptionResponseFactory.createValidationErrorResponse(BAD_REQUEST, httpServletRequest, notValidFields);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatch(
        MethodArgumentTypeMismatchException methodArgumentTypeMismatchException,
        HttpServletRequest httpServletRequest
    ) {
        String message = String.format("Invalid value for parameter '%s'. Expected %s.",
            methodArgumentTypeMismatchException.getName(), getExpectedTypeMessage(methodArgumentTypeMismatchException.getRequiredType()));
        return this.exceptionResponseFactory.createErrorResponse(BAD_REQUEST, httpServletRequest, message);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleMethodNotSupported(
        HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException,
        HttpServletRequest httpServletRequest
    ) {
        return this.exceptionResponseFactory.createErrorResponse(METHOD_NOT_ALLOWED, httpServletRequest, httpRequestMethodNotSupportedException.getMessage());
    }
    private String getExpectedTypeMessage(Class<?> requiredType) {
        return switch (requiredType != null ? requiredType.getSimpleName() : "Unknown") {
            case "Integer" -> "an integer";
            case "Double" -> "a decimal number";
            case "Boolean" -> "a boolean (true/false)";
            case "String" -> "a string";
            default -> "a value of type " + (requiredType != null ? requiredType.getSimpleName() : "unknown");
        };
    }
}
