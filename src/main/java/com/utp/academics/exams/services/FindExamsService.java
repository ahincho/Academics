package com.utp.academics.exams.services;

import com.utp.academics.exams.entities.ExamEntity;
import com.utp.academics.exams.mappers.ExamMapper;
import com.utp.academics.exams.presentation.dtos.ExamResponse;
import com.utp.academics.exams.repositories.ExamJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindExamsService {
    private final ExamJpaRepository examJpaRepository;
    private final ExamMapper examMapper;
    public FindExamsService(
        ExamJpaRepository examJpaRepository,
        ExamMapper examMapper
    ) {
        this.examJpaRepository = examJpaRepository;
        this.examMapper = examMapper;
    }
    public List<ExamResponse> execute() {
        List<ExamEntity> examEntities = this.examJpaRepository.findAll();
        return examEntities.stream().map(this.examMapper::entityToResponse).toList();
    }
}
