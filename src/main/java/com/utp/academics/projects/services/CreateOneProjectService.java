package com.utp.academics.projects.services;

import com.utp.academics.projects.entities.ProjectEntity;
import com.utp.academics.projects.mappers.ProjectMapper;
import com.utp.academics.projects.presentations.dtos.ProjectCreateRequest;
import com.utp.academics.projects.presentations.dtos.ProjectResponse;
import com.utp.academics.projects.repositories.ProjectJpaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOneProjectService {
    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectMapper projectMapper;
    public CreateOneProjectService(
        ProjectJpaRepository projectJpaRepository,
        ProjectMapper projectMapper
    ) {
        this.projectJpaRepository = projectJpaRepository;
        this.projectMapper = projectMapper;
    }
    @Transactional
    public ProjectResponse execute(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity projectEntity = this.projectMapper.requestToEntity(projectCreateRequest);
        ProjectEntity savedProjectEntity = this.projectJpaRepository.save(projectEntity);
        return ProjectMapper.entityToResponse(savedProjectEntity);
    }
}
