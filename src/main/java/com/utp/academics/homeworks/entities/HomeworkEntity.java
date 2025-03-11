package com.utp.academics.homeworks.entities;

import com.utp.academics.commons.entities.AcademicItemEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "homeworks")
@Entity(name = "homework")
public class HomeworkEntity extends AcademicItemEntity {
    private LocalDateTime deadline;
}
