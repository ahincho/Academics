package com.utp.academics.projects.repositories;

import com.utp.academics.projects.entities.ProjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectJpaRepository extends JpaRepository<ProjectEntity, Integer> {

}
