package com.utp.academics.projects.presentation.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Integer id;
    private String title;
    private Integer teamSize;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
