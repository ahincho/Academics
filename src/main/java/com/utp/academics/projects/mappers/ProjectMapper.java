package com.utp.academics.projects.mappers;

import com.utp.academics.commons.entities.AcademicItemType;
import com.utp.academics.commons.utils.AcademicItemFactory;
import com.utp.academics.projects.entities.ProjectEntity;
import com.utp.academics.projects.presentations.dtos.ProjectCreateRequest;
import com.utp.academics.projects.presentations.dtos.ProjectResponse;

import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private final AcademicItemFactory academicItemFactory;
    public ProjectMapper(AcademicItemFactory academicItemFactory) {
        this.academicItemFactory = academicItemFactory;
    }
    public ProjectEntity requestToEntity(ProjectCreateRequest projectCreateRequest) {
        return (ProjectEntity) this.academicItemFactory
            .createAcademicItem(AcademicItemType.PROJECT, projectCreateRequest.getTitle(), projectCreateRequest.getTeamSize());
    }
    public static ProjectResponse entityToResponse(ProjectEntity projectEntity) {
        return ProjectResponse.builder()
            .id(projectEntity.getId())
            .title(projectEntity.getTitle())
            .teamSize(projectEntity.getTeamSize())
            .createdAt(projectEntity.getCreatedAt())
            .updatedAt(projectEntity.getUpdatedAt())
            .build();
    }
}
