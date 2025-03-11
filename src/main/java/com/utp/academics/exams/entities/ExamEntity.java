package com.utp.academics.exams.entities;

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
@Table(name = "exams")
@Entity(name = "exam")
public class ExamEntity extends AcademicItemEntity {
    private Integer duration;
    private Integer maxScore;
}
