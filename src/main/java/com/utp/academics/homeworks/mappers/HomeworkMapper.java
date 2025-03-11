package com.utp.academics.homeworks.mappers;

import com.utp.academics.commons.entities.AcademicItemType;
import com.utp.academics.commons.utils.AcademicItemFactory;
import com.utp.academics.homeworks.entities.HomeworkEntity;
import com.utp.academics.homeworks.presentation.dtos.HomeworkCreateRequest;
import com.utp.academics.homeworks.presentation.dtos.HomeworkResponse;

import org.springframework.stereotype.Component;

@Component
public class HomeworkMapper {
    private final AcademicItemFactory academicItemFactory;
    public HomeworkMapper(AcademicItemFactory academicItemFactory) {
        this.academicItemFactory = academicItemFactory;
    }
    public HomeworkEntity requestToEntity(HomeworkCreateRequest homeworkCreateRequest) {
        return (HomeworkEntity) this.academicItemFactory
            .createAcademicItem(AcademicItemType.HOMEWORK, homeworkCreateRequest.getTitle(), homeworkCreateRequest.getDeadline());
    }
    public static HomeworkResponse entityToResponse(HomeworkEntity homeworkEntity) {
        return HomeworkResponse.builder()
            .id(homeworkEntity.getId())
            .title(homeworkEntity.getTitle())
            .deadline(homeworkEntity.getDeadline())
            .createdAt(homeworkEntity.getCreatedAt())
            .updatedAt(homeworkEntity.getUpdatedAt())
            .build();
    }
}
