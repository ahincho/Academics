package com.utp.academics.projects.presentation.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateRequest {
    @NotBlank
    private String title;
    @Positive
    @Min(2)
    private Integer teamSize;
}
