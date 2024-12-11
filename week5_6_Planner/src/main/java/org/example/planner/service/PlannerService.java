package org.example.planner.service;

import org.example.planner.dto.PlannerRequestDto;
import org.example.planner.dto.PlannerResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PlannerService {

    PlannerResponseDto savePlan(PlannerRequestDto requestDto);

    List<PlannerResponseDto> findAllPlans();

    PlannerResponseDto findPlanById(Long id);

    PlannerResponseDto updatePlan(Long id, String plans, String name, String password , LocalDateTime revisionDate);

    void deletePlanner(Long id);

}
