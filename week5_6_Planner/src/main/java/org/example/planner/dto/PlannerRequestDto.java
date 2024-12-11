package org.example.planner.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlannerRequestDto {
    private String plans;
    private String name;
    private String password;
    private LocalDateTime revision_date;
}
