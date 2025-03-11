package com.utp.academics.homeworks.services;

import com.utp.academics.homeworks.entities.HomeworkEntity;
import com.utp.academics.homeworks.mappers.HomeworkMapper;
import com.utp.academics.homeworks.presentation.dtos.HomeworkCreateRequest;
import com.utp.academics.homeworks.presentation.dtos.HomeworkResponse;
import com.utp.academics.homeworks.repositories.HomeworkJpaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOneHomeworkService {
    private final HomeworkJpaRepository homeworkJpaRepository;
    private final HomeworkMapper homeworkMapper;
    public CreateOneHomeworkService(
        HomeworkJpaRepository homeworkJpaRepository,
        HomeworkMapper homeworkMapper
    ) {
        this.homeworkJpaRepository = homeworkJpaRepository;
        this.homeworkMapper = homeworkMapper;
    }
    @Transactional
    public HomeworkResponse createOneHomework(HomeworkCreateRequest homeworkCreateRequest) {
        HomeworkEntity homeworkEntity = this.homeworkMapper.requestToEntity(homeworkCreateRequest);
        HomeworkEntity savedHomeworkEntity = this.homeworkJpaRepository.save(homeworkEntity);
        return HomeworkMapper.entityToResponse(savedHomeworkEntity);
    }
}
