package com.eazybytes.loans.controller;

import com.eazybytes.loans.constants.LoanConstants;
import com.eazybytes.loans.dto.ContactDetails;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.dto.ResponseDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.service.ILoanService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
@Tag(
        name = "CRUD operation for Loan service",
        description = "CRUD APIs for loan microservice to read, create, update and delete operation"
)
@RestController
@RequestMapping("/api/loan")
@Validated
public class LoanController {


    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private ILoanService iLoanService;

    @Value(value = "${build.version}")
    private String buildInfo;

    @Autowired
    private ContactDetails contactDetails;

    @Autowired
    private Environment environment;

    @Operation(
            summary = "create account REST API",
            description = "Rest API to create new Loan"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                      @Pattern(regexp = "^$|[0-9]{10}", message = "the length of mobile number must be 10") String mobileNumber){
        iLoanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));

    }


    @GetMapping("/fetch")
    @Operation(
            summary = "fetch loan details",
            description = "REST API to fetch loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    public ResponseEntity<LoanDto> fetchLoanDetails(
                                                        @RequestHeader("eazyBank-correlation-id") String correlationId,
                                                        @RequestParam @Pattern(regexp = "^$|[0-9]{10}", message = "the length of mobile number must be 10")
                                                        String mobileNumber){
        logger.debug("eazyBank-correlation-id found : {}", correlationId);
        LoanDto loanDto = iLoanService.fetchLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDto);
    }

    @Operation(
            summary = "UPDATE REST API",
            description = "REST API to update loan details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status Ok"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status FAILED",
                    content = @Content(
                            schema = @Schema(implementation = Exception.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@RequestBody
                                                             @Pattern(regexp = "^$|[0-9]{10}", message = "the length of mobile number must be 10")
                                                             LoanDto loanDto){
        boolean isUpdated = iLoanService.updateLoanDetails(loanDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417,  LoanConstants.MESSAGE_417_UPDATE));
        }
    }


    @Operation(
            summary = "DELETE REST API",
            description = "REST API to delete loan entry"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    @DeleteMapping("delete")
    public ResponseEntity<ResponseDto> deleteLoanEntry(@RequestParam
                                                           @Pattern(regexp = "^$|[0-9]{10}", message = "the length of mobile number must be 10")
                                                           String mobileNumber){
        boolean isUpdated = iLoanService.deleteLoanEntry(mobileNumber);
        if (isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200)
            );
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }


    @Operation(
            summary = "fetch build details",
            description = "REST API to fetch build details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildInfo);
    }


    @Operation(
            summary = "fetch java details",
            description = "REST API to fetch java details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    @GetMapping("/java-info")
    public ResponseEntity<String> getJavaInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(
            summary = "fetch java details",
            description = "REST API to fetch java details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP status FAILED",
                    content = @Content(
                            schema = @Schema(
                                    implementation = Exception.class
                            )
                    )
            )
    })
    @GetMapping("/contact-info")
    public ResponseEntity<ContactDetails> getContactInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactDetails);
    }

}
