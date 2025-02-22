package com.technicaltestprogessoft.mapper;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.entity.Deal;
import org.springframework.stereotype.Component;

@Component
public class DealMapper {

    public Deal toEntity(DealRequestDto dealRequestDto) {
        Deal deal = new Deal();
        deal.setId(dealRequestDto.id());
        deal.setFromCurrency(dealRequestDto.fromCurrency());
        deal.setToCurrency(dealRequestDto.toCurrency());
        deal.setTimestamp(dealRequestDto.timestamp());
        deal.setAmount(dealRequestDto.amount());
        return deal;
    }

    public DealResponseDto toResponseEntity(Deal deal) {
        return new DealResponseDto(
                deal.getId(),
                deal.getFromCurrency(),
                deal.getToCurrency(),
                deal.getTimestamp(),
                deal.getAmount()
        );
    }
}
