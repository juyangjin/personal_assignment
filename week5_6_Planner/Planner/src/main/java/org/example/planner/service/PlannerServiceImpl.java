package org.example.planner.service;


import org.example.planner.controller.PlannerController;
import org.example.planner.dto.PlannerRequestDto;
import org.example.planner.dto.PlannerResponseDto;
import org.example.planner.entity.Planner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.example.planner.repository.PlannerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Annotation @Service는 @Component와 같다, Spring Bean으로 등록한다는 뜻.
 * Spring Bean으로 등록되면 다른 클래스에서 주입하여 사용할 수 있다.
 * 명시적으로 Service Layer 라는것을 나타낸다.
 * 비지니스 로직을 수행한다.
 */
@Service
public class PlannerServiceImpl implements PlannerService {

    private final PlannerRepository plannerRepository;

    public PlannerServiceImpl(PlannerRepository plannerRepository) {
        this.plannerRepository = plannerRepository;
    }

    @Override
    public PlannerResponseDto savePlan(PlannerRequestDto requestDto) {

        //요청받은 데이터로 일정 생성
        Planner planner = new Planner(requestDto.getPlans(), requestDto.getName(),requestDto.getPassword(), LocalDateTime.now());
        return plannerRepository.savePlan(planner);
    }

    @Override
    public List<PlannerResponseDto> findAllPlans() {

        //전체 조회
        List<PlannerResponseDto> allPlans = plannerRepository.findAllPlans();

        return allPlans;
    }

    @Override
    public PlannerResponseDto findPlanById(Long id) {

        //선택 조회
        Planner planner = plannerRepository.findPlanByIdOrElseThrow(id);

        return new PlannerResponseDto(planner);
    }


    @Transactional
    @Override
    public PlannerResponseDto updatePlan(Long id, String plans, String name, String password ,LocalDateTime revision_date) {


        Planner planner = plannerRepository.findPlanByIdOrElseThrow(id);

        if(!planner.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST," 비밀번호 오답");
        }

        //필수값 검증
        if(plans == null || name == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The plan and date are required values.");
        }

        //plan 수정
        int updatedRow = plannerRepository.updatePlan(id, plans, name, revision_date);

        //수정된 row가 0이라면
        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        return new PlannerResponseDto(plannerRepository.findPlanById(id).get());
    }

    @Override
    public void deletePlanner(Long id) {
        //일정 삭제
        int deletedRow = plannerRepository.deletePlan(id);
        //삭제된 row가 0개 라면
        if(deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

    }

}
