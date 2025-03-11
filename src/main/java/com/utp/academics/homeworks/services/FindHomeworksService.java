package com.utp.academics.homeworks.services;

import com.utp.academics.homeworks.entities.HomeworkEntity;
import com.utp.academics.homeworks.mappers.HomeworkMapper;
import com.utp.academics.homeworks.presentation.dtos.HomeworkResponse;
import com.utp.academics.homeworks.repositories.HomeworkJpaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindHomeworksService {
    public final HomeworkJpaRepository homeworkJpaRepository;
    public FindHomeworksService(HomeworkJpaRepository homeworkJpaRepository) {
        this.homeworkJpaRepository = homeworkJpaRepository;
    }
    public List<HomeworkResponse> execute() {
        List<HomeworkEntity> homeworkEntities = this.homeworkJpaRepository.findAll();
        return homeworkEntities.stream().map(HomeworkMapper::entityToResponse).toList();
    }
}
