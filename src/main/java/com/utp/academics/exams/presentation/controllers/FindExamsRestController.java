package com.utp.academics.exams.presentation.controllers;

import com.utp.academics.exams.presentation.dtos.ExamResponse;
import com.utp.academics.exams.presentation.utils.ExamPaths;
import com.utp.academics.exams.services.FindExamsService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ExamPaths.EXAMS)
public class FindExamsRestController {
    private final FindExamsService findExamsService;
    public FindExamsRestController(FindExamsService findExamsService) {
        this.findExamsService = findExamsService;
    }
    @GetMapping
    public ResponseEntity<List<ExamResponse>> findExams() {
        List<ExamResponse> examResponses = this.findExamsService.execute();
        if (examResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(examResponses);
    }
}
