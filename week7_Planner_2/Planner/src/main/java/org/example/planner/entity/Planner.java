package org.example.planner.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Planner {
    private Long id;
    private String plans;
    private String name;
    private String password;
    private LocalDateTime date;
    private LocalDateTime revision_date;


    public Planner(String plans, String name, String password, LocalDateTime date) {
        this.plans = plans;
        this.name = name;
        this.password = password;
        this.date = date;
        this.revision_date = date;
    }

    public Planner(Long id, String plans, String name, String password, Timestamp date, Timestamp revision_date) {
        this.id = id;
        this.plans = plans;
        this.name = name;
        this.password = password;
        this.date = date.toLocalDateTime();
        this.revision_date = revision_date.toLocalDateTime();
    }

}
