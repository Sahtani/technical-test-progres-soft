package com.technicaltestprogessoft.mapper;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.entity.Deal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealMapper {
    Deal toEntity(DealRequestDto dto);

    DealResponseDto toResponseEntity(Deal deal);
}
