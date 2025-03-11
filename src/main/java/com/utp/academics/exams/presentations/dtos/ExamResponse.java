package com.utp.academics.exams.presentations.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamResponse {
    private Integer id;
    private String title;
    private Integer duration;
    private Integer maxScore;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
