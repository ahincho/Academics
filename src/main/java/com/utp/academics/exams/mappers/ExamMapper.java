package com.utp.academics.exams.mappers;

import com.utp.academics.commons.entities.AcademicItemType;
import com.utp.academics.commons.utils.AcademicItemFactory;
import com.utp.academics.exams.entities.ExamEntity;
import com.utp.academics.exams.presentations.dtos.ExamCreateRequest;
import com.utp.academics.exams.presentations.dtos.ExamResponse;

import org.springframework.stereotype.Component;

@Component
public class ExamMapper {
    private final AcademicItemFactory academicItemFactory;
    public ExamMapper(AcademicItemFactory academicItemFactory) {
        this.academicItemFactory = academicItemFactory;
    }
    public ExamEntity requestToEntity(ExamCreateRequest examCreateRequest) {
        return (ExamEntity) this.academicItemFactory
            .createAcademicItem(AcademicItemType.EXAM, examCreateRequest.getTitle(), examCreateRequest.getDuration(), examCreateRequest.getMaxScore());
    }
    public ExamResponse entityToResponse(ExamEntity examEntity) {
        return ExamResponse.builder()
            .id(examEntity.getId())
            .title(examEntity.getTitle())
            .duration(examEntity.getDuration())
            .maxScore(examEntity.getMaxScore())
            .createdAt(examEntity.getCreatedAt())
            .updatedAt(examEntity.getUpdatedAt())
            .build();
    }
}
