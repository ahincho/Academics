package com.utp.academics.exams.repositories;

import com.utp.academics.exams.entities.ExamEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamJpaRepository extends JpaRepository<ExamEntity, Integer> {

}
