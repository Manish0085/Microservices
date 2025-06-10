package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.ContactDetailsDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {


    @Autowired
    private Environment environment;


    @Autowired
    private ContactDetailsDto contactDetailsDto;


    @GetMapping
    public String getString(){
        return "Learning Microservices";
    }



    @Operation(
            summary = "Get Contact Information",
            description = "REST APIs to get the contact information"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/contact-info")
    public ResponseEntity<ContactDetailsDto> getContactInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactDetailsDto);
    }
}
