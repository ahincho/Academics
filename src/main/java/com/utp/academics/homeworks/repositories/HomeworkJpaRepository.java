package com.utp.academics.homeworks.repositories;

import com.utp.academics.homeworks.entities.HomeworkEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkJpaRepository extends JpaRepository<HomeworkEntity, Integer> {

}
