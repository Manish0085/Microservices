package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountsDto {


    @Schema(
        description = "Account Number of Eazy Bank account", example = "8546954111"
    )
    @NotEmpty(message = "Account number cannot be null or empty")
    @Pattern(regexp = "$|[0-9]{10}", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of Eazy Bank account", example = "Saving"
    )
    @NotEmpty(message = "Account Type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Eazy Bank Branch Address", example = "123 New York"
    )
    @NotEmpty(message = "Branch Address cannot be null or empty")
    private String branchAddress;



    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
