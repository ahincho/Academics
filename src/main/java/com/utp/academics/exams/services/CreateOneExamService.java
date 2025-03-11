package com.utp.academics.exams.services;

import com.utp.academics.exams.entities.ExamEntity;
import com.utp.academics.exams.mappers.ExamMapper;
import com.utp.academics.exams.presentation.dtos.ExamCreateRequest;
import com.utp.academics.exams.presentation.dtos.ExamResponse;
import com.utp.academics.exams.repositories.ExamJpaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOneExamService {
    private final ExamJpaRepository examJpaRepository;
    private final ExamMapper examMapper;
    public CreateOneExamService(
        ExamJpaRepository examJpaRepository,
        ExamMapper examMapper
    ) {
        this.examJpaRepository = examJpaRepository;
        this.examMapper = examMapper;
    }
    @Transactional
    public ExamResponse execute(ExamCreateRequest examCreateRequest) {
        ExamEntity examEntity = this.examMapper.requestToEntity(examCreateRequest);
        ExamEntity savedExamEntity = this.examJpaRepository.save(examEntity);
        return this.examMapper.entityToResponse(savedExamEntity);
    }
}
