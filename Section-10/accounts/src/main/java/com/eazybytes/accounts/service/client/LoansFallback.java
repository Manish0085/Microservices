package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class LoansFallback implements LoanFeignClient{
    @Override
    public ResponseEntity<LoanDto> fetchLoanDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
