package com.technicaltestprogessoft.service;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.entity.Deal;
import com.technicaltestprogessoft.exception.DealAlreadyExistsException;
import com.technicaltestprogessoft.mapper.DealMapper;
import com.technicaltestprogessoft.repository.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final DealMapper dealMapper;

    public DealServiceImpl(DealRepository dealRepository, DealMapper dealMapper) {
        this.dealRepository = dealRepository;
        this.dealMapper = dealMapper;
    }

    @Override
    public DealResponseDto createDeal(DealRequestDto dealRequestDto) {
        log.info("Attempting to create deal with ID: {}", dealRequestDto.id());

        if (dealRepository.existsById(dealRequestDto.id())) {
            log.warn("Duplicate deal ID detected: {}. Operation aborted.", dealRequestDto.id());
            throw new DealAlreadyExistsException("Deal with ID " + dealRequestDto.id() + " already exists.");
        }

        Deal savedDeal = dealRepository.save(dealMapper.toEntity(dealRequestDto));
        log.info("Deal created successfully with ID: {}", savedDeal.getId());

        return dealMapper.toResponseEntity(savedDeal);
    }
}
