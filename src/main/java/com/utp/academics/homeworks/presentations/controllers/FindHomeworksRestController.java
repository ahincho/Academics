package com.utp.academics.homeworks.presentations.controllers;

import com.utp.academics.homeworks.presentations.dtos.HomeworkResponse;
import com.utp.academics.homeworks.presentations.utils.HomeworkPaths;
import com.utp.academics.homeworks.services.FindHomeworksService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HomeworkPaths.HOMEWORKS)
public class FindHomeworksRestController {
    private final FindHomeworksService findHomeworksService;
    public FindHomeworksRestController(FindHomeworksService findHomeworksService) {
        this.findHomeworksService = findHomeworksService;
    }
    @GetMapping
    public ResponseEntity<List<HomeworkResponse>> findHomeworks() {
        List<HomeworkResponse> homeworkResponses = this.findHomeworksService.execute();
        if (homeworkResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(homeworkResponses);
    }
}
