package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Success Response"
)
public class ResponseDto {

    @Schema(
            description = "Http Response"
    )
    private String statusCode;

    @Schema(
            description = "Status Message"
    )
    private String statusMsg;


}
