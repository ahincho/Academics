package com.utp.academics.homeworks.presentations.controllers;

import com.utp.academics.homeworks.presentations.dtos.HomeworkCreateRequest;
import com.utp.academics.homeworks.presentations.dtos.HomeworkResponse;
import com.utp.academics.homeworks.presentations.utils.HomeworkPaths;
import com.utp.academics.homeworks.services.CreateOneHomeworkService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(HomeworkPaths.HOMEWORKS)
public class CreateHomeworkRestController {
    private final CreateOneHomeworkService createOneHomeworkService;
    public CreateHomeworkRestController(CreateOneHomeworkService createOneHomeworkService) {
        this.createOneHomeworkService = createOneHomeworkService;
    }
    @PostMapping
    public ResponseEntity<HomeworkResponse> createOneHomework(
        @RequestBody @Valid HomeworkCreateRequest homeworkCreateRequest
    ) {
        HomeworkResponse homeworkResponse = createOneHomeworkService.createOneHomework(homeworkCreateRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{homeworkId}").buildAndExpand(homeworkResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(homeworkResponse);
    }
}
