package com.eazybytes.accounts.service.client;


import com.eazybytes.accounts.dto.CardDto;
import com.eazybytes.accounts.dto.LoanDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "loans", fallback = LoansFallback.class)
public interface LoanFeignClient {


    @GetMapping(value = "/api/loan/fetch", consumes = "application/json")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestHeader("eazyBank-correlation-id") String correlationId, @RequestParam String mobileNumber);

}
