package org.example.planner.repository;


import org.example.planner.dto.PlannerResponseDto;
import org.example.planner.entity.Planner;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class JdbcTemplatePlannerRepository implements PlannerRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePlannerRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 생성
    @Override
    public PlannerResponseDto savePlan(Planner planner) {
        //INSERT Query를 직접 작성하지 않아도 된다.
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("planner").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("plans", planner.getPlans());
        parameters.put("name", planner.getName());
        parameters.put("password", planner.getPassword());
        parameters.put("date", LocalDateTime.now());
        parameters.put("revision_date", LocalDateTime.now());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new PlannerResponseDto(key.longValue(), planner.getPlans(), planner.getName(), LocalDateTime.now(),LocalDateTime.now());
    }

    // 전체 조회
    @Override
    public List<PlannerResponseDto> findAllPlans() {
        return jdbcTemplate.query
                ("select * from planner", planRowMapper());
    }

    private RowMapper<PlannerResponseDto> planRowMapper() {
        return new RowMapper<PlannerResponseDto>() {
            @Override
            public PlannerResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new PlannerResponseDto(
                        rs.getLong("id"),
                        rs.getString("plans"),
                        rs.getString("name"),
                        rs.getTimestamp("date"),
                        rs.getTimestamp("revision_date")
                );
            }
        };
    }


    // 선택 조회
    @Override
    public Optional<Planner> findPlanById(Long id) {
        List<Planner> result = jdbcTemplate.query("select * from planner where id = ?", planRowMapperV2(),id);

        return result.stream().findAny();
    }


    private RowMapper<Planner> planRowMapperV2() {
        return new RowMapper<Planner>() {
            @Override
            public Planner mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Planner(
                        rs.getLong("id"),
                        rs.getString("plans"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getTimestamp("date"),
                        rs.getTimestamp("revision_date")
                );
            }
        };
    }

    @Override
    public int updatePlan(Long id, String plans, String name,LocalDateTime revision_date) {
        return jdbcTemplate.update("update planner set plans = ?, name = ?, revision_date = ? where id = ?", plans, name, LocalDateTime.now() ,id);
    }


    @Override
    public int deletePlan(Long id) {
        return jdbcTemplate.update("delete from planner where id =?", id);
    }

    @Override
    public Planner findPlanByIdOrElseThrow(Long id) {
        List<Planner> result = jdbcTemplate.query("select * from planner where id = ?", planRowMapperV2(), id);

        return  result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }

}
