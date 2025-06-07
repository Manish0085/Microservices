package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer Details",
        description = "Schema to hold customer, account, cards and loans details"
)
public class CustomerDetailsDto {


    @Schema(
            description = "Name of the customer", example = "abc"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email Address of the customer", example = "abc123@gmail.com"
    )
    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "0123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account Schema"
    )
    private AccountDto accountDto;

    @Schema(
            description = "Card Schema"
    )
    private CardDto cardDto;

    @Schema(
            description = "Loan Schema"
    )
    private LoanDto loanDto;

}
