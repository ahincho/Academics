package com.utp.academics.projects.entities;

import com.utp.academics.commons.entities.AcademicItemEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "projects")
@Entity(name = "project")
public class ProjectEntity extends AcademicItemEntity {
    private Integer teamSize;
}
