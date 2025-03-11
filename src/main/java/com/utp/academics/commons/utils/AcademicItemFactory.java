package com.utp.academics.commons.utils;

import com.utp.academics.commons.entities.AcademicItemEntity;
import com.utp.academics.commons.entities.AcademicItemType;
import com.utp.academics.exams.entities.ExamEntity;
import com.utp.academics.homeworks.entities.HomeworkEntity;
import com.utp.academics.projects.entities.ProjectEntity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AcademicItemFactory {
    public AcademicItemEntity createAcademicItem(AcademicItemType academicItemType, String title, Object... args) {
        switch (academicItemType) {
            case HOMEWORK:
                HomeworkEntity homeworkEntity = new HomeworkEntity();
                homeworkEntity.setTitle(title);
                homeworkEntity.setDeadline((LocalDateTime) args[0]);
                return homeworkEntity;
            case EXAM:
                ExamEntity examEntity = new ExamEntity();
                examEntity.setTitle(title);
                examEntity.setDuration((Integer) args[0]);
                examEntity.setMaxScore((Integer) args[1]);
                return examEntity;
            case PROJECT:
                ProjectEntity projectEntity = new ProjectEntity();
                projectEntity.setTitle(title);
                projectEntity.setTeamSize((Integer) args[0]);
                return projectEntity;
            default:
                throw new IllegalArgumentException("Unsupported academic item type: " + academicItemType);
        }
    }
}
