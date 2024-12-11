package org.example.planner.dto;

import lombok.Setter;
import org.example.planner.entity.Planner;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PlannerResponseDto {

    private Long id;
    private String plans;
    private String name;
    private LocalDateTime date;
    private LocalDateTime revision_date;


    public PlannerResponseDto(Planner planner){
        this.id = planner.getId();
        this.plans = planner.getPlans();
        this.name = planner.getName();
        this.date = planner.getDate();
        this.revision_date = planner.getRevision_date();
    }

    public PlannerResponseDto(long id, String plans, String name, Timestamp date, Timestamp revisionDate) {
    this.id = id;
    this.plans = plans;
    this.name = name;
    this.date = date.toLocalDateTime();
    this.revision_date = revisionDate.toLocalDateTime();
    }

    }
