package org.example.planner.controller;

import org.example.planner.dto.PlannerRequestDto;
import org.example.planner.dto.PlannerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.planner.service.PlannerService;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/planner") //Prefix
public class PlannerController {

    //의존성을 변경할 수 없게 하여 상태 유지
    private final PlannerService plannerService;

    /*
    생성자 주입
    클래스가 필요로하는 의존성을 생성자를 통하여 전달
     */
    public PlannerController(PlannerService plannerService){
        this.plannerService = plannerService;
    }


    /*
    일정 생성 API
     */
    @PostMapping
    public ResponseEntity<PlannerResponseDto> createPlanner(@RequestBody PlannerRequestDto requestDto){

        return new ResponseEntity<>(plannerService.savePlan(requestDto), HttpStatus.CREATED);
    }

    /*
    일정 전체 조회 API
     */
    @GetMapping
    public List<PlannerResponseDto> findAllPlans(){

        return plannerService.findAllPlans();
    }

    /*
    일정 선택 조회 API
     */
    @GetMapping("/{id}")
    public ResponseEntity<PlannerResponseDto> findPlanById (@PathVariable Long id){
        return new ResponseEntity<>(plannerService.findPlanById(id), HttpStatus.OK);
    }

    /*
    일정 전체 수정 API
     */
    @PutMapping("/{id}")
    public ResponseEntity<PlannerResponseDto> updatePlan(
            @PathVariable Long id,
            @RequestBody PlannerRequestDto requestDto
    ){
        return new ResponseEntity<>(plannerService.updatePlan(id, requestDto.getPlans(), requestDto.getName(), requestDto.getPassword() , LocalDateTime.now()), HttpStatus.OK);
    }

    // 선택 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {

        plannerService.deletePlanner(id);
        //성공한 경우
        return new ResponseEntity<>(HttpStatus.OK);
    }

;}
