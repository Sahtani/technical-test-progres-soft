package com.technicaltestprogessoft.service;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.entity.Deal;
import com.technicaltestprogessoft.exception.DealAlreadyExistsException;
import com.technicaltestprogessoft.mapper.DealMapper;
import com.technicaltestprogessoft.repository.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealServiceImplTest {

    @Mock
    private DealRepository dealRepository;

    @Mock
    private DealMapper dealMapper;

    @InjectMocks
    private DealServiceImpl dealService;

    private DealRequestDto dealRequestDto;
    private Deal deal;
    private DealResponseDto dealResponseDto;

    @BeforeEach
    void setUp() {
        dealRequestDto = new DealRequestDto(
                "123",
                Currency.getInstance("USD"),
                Currency.getInstance("EUR"),
                LocalDateTime.now(),
                BigDecimal.valueOf(100.50)
        );

        deal = new Deal(
                "123",
                Currency.getInstance("USD"),
                Currency.getInstance("EUR"),
                LocalDateTime.now(),
                BigDecimal.valueOf(100.50)
        );
        dealResponseDto = new DealResponseDto(
                "123",
                Currency.getInstance("USD"),
                Currency.getInstance("EUR"),
                LocalDateTime.now(),
                BigDecimal.valueOf(100.50)
        );
    }

    @Test
    void createDeal_ShouldReturnDealResponseDto_WhenDealDoesNotExist() {
        when(dealRepository.existsById(dealRequestDto.id())).thenReturn(false);
        when(dealMapper.toEntity(dealRequestDto)).thenReturn(deal);
        when(dealRepository.save(deal)).thenReturn(deal);
        when(dealMapper.toResponseEntity(deal)).thenReturn(dealResponseDto);

        DealResponseDto result = dealService.createDeal(dealRequestDto);

        assertNotNull(result);
        assertEquals(dealRequestDto.id(), result.id());
        verify(dealRepository, times(1)).save(deal);
    }

    @Test
    void createDeal_ShouldThrowDealAlreadyExistsException_WhenDealExists() {
        when(dealRepository.existsById(dealRequestDto.id())).thenReturn(true);

        assertThrows(DealAlreadyExistsException.class, () -> dealService.createDeal(dealRequestDto));

        verify(dealRepository, never()).save(any(Deal.class));
    }


}
