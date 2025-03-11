package com.utp.academics.projects.services;

import com.utp.academics.projects.entities.ProjectEntity;
import com.utp.academics.projects.mappers.ProjectMapper;
import com.utp.academics.projects.presentations.dtos.ProjectResponse;
import com.utp.academics.projects.repositories.ProjectJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProjectsService {
    private final ProjectJpaRepository projectJpaRepository;
    public FindProjectsService(ProjectJpaRepository projectJpaRepository) {
        this.projectJpaRepository = projectJpaRepository;
    }
    public List<ProjectResponse> execute() {
        List<ProjectEntity> projectEntities = this.projectJpaRepository.findAll();
        return projectEntities.stream().map(ProjectMapper::entityToResponse).toList();
    }
}
