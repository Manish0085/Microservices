package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.dto.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Fallback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", fallback = CardFallback.class)
public interface CardFeignClient {


    @GetMapping(value = "/api/card/fetch", consumes = "application/json")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestHeader("eazyBank-correlation-id") String correlationId, @RequestParam String mobileNumber);

}
