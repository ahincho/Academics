package com.utp.academics.exams.presentations.controllers;

import com.utp.academics.exams.presentations.dtos.ExamCreateRequest;
import com.utp.academics.exams.presentations.dtos.ExamResponse;
import com.utp.academics.exams.presentations.utils.ExamPaths;
import com.utp.academics.exams.services.CreateOneExamService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(ExamPaths.EXAMS)
public class CreateOneExamRestController {
    private final CreateOneExamService createOneExamService;
    public CreateOneExamRestController(CreateOneExamService createOneExamService) {
        this.createOneExamService = createOneExamService;
    }
    @PostMapping
    public ResponseEntity<ExamResponse> createOneExam(
        @RequestBody @Valid ExamCreateRequest examCreateRequest
    ) {
        ExamResponse examResponse = this.createOneExamService.execute(examCreateRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{examId}").buildAndExpand(examResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(examResponse);
    }
}
