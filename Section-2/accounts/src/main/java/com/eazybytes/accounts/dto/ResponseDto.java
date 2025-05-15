package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data
public class ResponseDto {

    @Schema(
            description = "Status code in the response", example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response", example = "Request Processed Successfully"
    )
    private String statusMsg;

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public String getStatus() { return statusCode; }
    public String getMessage() { return statusMsg; }

    public void setStatus(String status) { this.statusCode = status; }
    public void setMessage(String message) { this.statusMsg = message; }
}
