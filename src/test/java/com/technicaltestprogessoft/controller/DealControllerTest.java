package com.technicaltestprogessoft.controller;

import com.technicaltestprogessoft.dto.DealRequestDto;
import com.technicaltestprogessoft.dto.DealResponseDto;
import com.technicaltestprogessoft.entity.Deal;
import com.technicaltestprogessoft.exception.DealAlreadyExistsException;
import com.technicaltestprogessoft.service.DealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DealControllerTest {

    @InjectMocks
    private DealController dealController;

    @Mock
    private DealService dealService;

    private DealRequestDto dealRequestDto;
    private Deal deal;
    private DealResponseDto dealResponseDto;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dealRequestDto = new DealRequestDto(
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
    public void createDeal_ShouldThrowDealAlreadyExistsException_WhenDealExists() {
        when(dealService.createDeal(any(DealRequestDto.class))).thenReturn(dealResponseDto);
        ResponseEntity<DealResponseDto> responseEntity = dealController.save(dealRequestDto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(dealResponseDto, responseEntity.getBody());

    }

    @Test
    void givenAlreadyExistingDealId_whenCreateDeal_thenThrowDealAlreadyExistsException() {
        given(dealService.createDeal(any(DealRequestDto.class)))
                .willThrow(new DealAlreadyExistsException("Deal id already exists"));

        assertThatExceptionOfType(DealAlreadyExistsException.class)
                .isThrownBy(() -> dealController.save(dealRequestDto))
                .withMessage("Deal id already exists");

        verify(dealService).createDeal(dealRequestDto);
    }
}
