package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold error response "
)
public class ErrorResponseDto
{

    @Schema(
            description = "API path where the error occurred"
    )
    private String apiPath;

    @Schema(
            description = "Error Status Code"
    )
    private HttpStaus errorCode;

    @Schema(
            description = "Error Message"
    )
    private String errorMessage;

    @Schema(
            description = "Error Time"
    )
    private LocalDateTime errorTime;
}
