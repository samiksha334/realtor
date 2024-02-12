package com.realtor.controller;

import com.realtor.payload.OwnerPlanDto;
import com.realtor.service.OwnerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/OwnerPlan")
public class OwnerPlanController {
    @Autowired
    private OwnerPlanService ownerPlanService;
    @PostMapping
    public ResponseEntity<OwnerPlanDto>createOwnerPlan(@RequestBody OwnerPlanDto ownerPlanDto){
        OwnerPlanDto dto=ownerPlanService.createOwnerPlans(ownerPlanDto);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @GetMapping
    public List<OwnerPlanDto> getAllOwnerPlans(){

        return   ownerPlanService.getAllOwnerPlans();


    }
}

