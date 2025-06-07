package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoanDto {

    @NotEmpty(message = "Loan number cannot be null")
    @Pattern(regexp = "^$|[0-9]{12}", message = "Loan number must be 12 digits")
    @Schema(
            description = "Loan Number"
    )
    private String loanNumber;

    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digit")
    @Schema(
            description = "Mobile Number"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan type cannot be null or empty")
    @Schema(
            description = "Loan Type"
    )
    private String loanType;

    @PositiveOrZero(message = "Total loan amount must be grater or equal to zero")
    @Schema(
            description = "Total Loan Amount"
    )
    private double totalLoan;

    @PositiveOrZero(message = "Total loan amount paid must be grater or equal to zero")
    @Schema(
            description = "Total PAid Amount"
    )
    private double amountPaid;

    @PositiveOrZero(message = "Total outstanding amount must be grater or equal to zero")
    @Schema(
            description = "Outstanding Amount"
    )
    private double outstandingAmount;

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double totalLoan) {
        this.totalLoan = totalLoan;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
