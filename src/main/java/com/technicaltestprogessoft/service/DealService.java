package com.technicaltestprogessoft.service;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;

public interface DealService {
     DealResponseDto createDeal(DealRequestDto dealRequestDto);
}
