package com.utp.academics.projects.presentation.controllers;

import com.utp.academics.projects.presentation.dtos.ProjectCreateRequest;
import com.utp.academics.projects.presentation.dtos.ProjectResponse;
import com.utp.academics.projects.presentation.utils.ProjectPaths;
import com.utp.academics.projects.services.CreateOneProjectService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(ProjectPaths.PROJECTS)
public class CreateOneProjectRestController {
    private final CreateOneProjectService createOneProjectService;
    public CreateOneProjectRestController(CreateOneProjectService createOneProjectService) {
        this.createOneProjectService = createOneProjectService;
    }
    @PostMapping
    public ResponseEntity<ProjectResponse> createOneProject(
        @RequestBody @Valid ProjectCreateRequest projectCreateRequest
    ) {
        ProjectResponse projectResponse = this.createOneProjectService.execute(projectCreateRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{projectId}").buildAndExpand(projectResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(projectResponse);
    }
}
