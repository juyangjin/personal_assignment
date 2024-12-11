package org.example.planner.repository;

import org.example.planner.dto.PlannerResponseDto;
import org.example.planner.entity.Planner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PlannerRepository {

    PlannerResponseDto savePlan(Planner planner);

    Planner findPlanByIdOrElseThrow(Long id);

    List<PlannerResponseDto> findAllPlans();
    Optional<Planner> findPlanById(Long id);
    int updatePlan(Long id, String plans, String name, LocalDateTime revision_date);
    int deletePlan(Long id);
}
