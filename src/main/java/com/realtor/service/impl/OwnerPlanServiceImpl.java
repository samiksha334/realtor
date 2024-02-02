package com.realtor.service.impl;

import com.realtor.entity.OwnerPlan;
import com.realtor.payload.OwnerPlanDto;

import com.realtor.repository.OwnerPlanRepository;
import com.realtor.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {



    private OwnerPlanRepository ownerPlanRepository;

    //we should use this when we get that error ..error creating a bean bcz
    // the spring ioc doesnt has information about model mapper..model mapper itself is a different library
    private ModelMapper modelMapper;
    //is a built in class coming from another library for those things we have to use @Bean

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository,ModelMapper modelMapper) {
        this.ownerPlanRepository = ownerPlanRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan=mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan=ownerPlanRepository.save(ownerPlan);
        return mapToDto(savedOwnerPlan);

    }

    @Override
    public List<OwnerPlanDto> getAllOwnerPlans() {
        List<OwnerPlan> ownerPlans=ownerPlanRepository.findAll();
        List<OwnerPlanDto>ownerPlanDtos=ownerPlans.stream().map(plan->mapToDto(plan)).collect(Collectors.toList());
        return ownerPlanDtos;
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan=modelMapper.map(ownerPlanDto,OwnerPlan.class);
        return  ownerPlan;
    }
    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){
        OwnerPlanDto ownerPlanDto=  modelMapper.map(ownerPlan,OwnerPlanDto.class);
        return  ownerPlanDto;
    }
}
