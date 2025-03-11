package com.utp.academics.homeworks.presentation.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkCreateRequest {
    @NotBlank
    private String title;
    @NotNull
    @Future
    private LocalDateTime deadline;
}
