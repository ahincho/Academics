package com.utp.academics.projects.presentation.controllers;

import com.utp.academics.projects.presentation.dtos.ProjectResponse;
import com.utp.academics.projects.presentation.utils.ProjectPaths;
import com.utp.academics.projects.services.FindProjectsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProjectPaths.PROJECTS)
public class FindProjectsRestController {
    private final FindProjectsService findProjectsService;
    public FindProjectsRestController(FindProjectsService findProjectsService) {
        this.findProjectsService = findProjectsService;
    }
    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findProjects() {
        List<ProjectResponse> projectResponses = this.findProjectsService.execute();
        if (projectResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projectResponses);
    }
}
