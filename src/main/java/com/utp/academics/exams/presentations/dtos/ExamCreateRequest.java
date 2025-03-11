package com.utp.academics.exams.presentations.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamCreateRequest {
    @NotBlank
    private String title;
    @Positive
    @Min(5)
    private Integer duration;
    @Positive
    @Min(5)
    private Integer maxScore;
}
