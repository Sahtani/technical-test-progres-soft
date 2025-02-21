package com.technicaltestprogessoft.controller;


import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.service.DealService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deals")
public class DealController {
    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }
    @PostMapping
    public ResponseEntity<DealResponseDto> save(@RequestBody @Valid DealRequestDto dto) {
        DealResponseDto deal = dealService.createDeal(dto);

        return new ResponseEntity<>(deal, HttpStatus.CREATED);
    }

}
