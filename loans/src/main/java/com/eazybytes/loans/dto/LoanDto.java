package com.eazybytes.loans.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoanDto {

    @NotEmpty(message = "Loan number cannot be null")
    @Pattern(regexp = "^$|[0-9]{12}", message = "Loan number must be 12 digits")
    private Long loanNumber;

    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Mobile number must be 10 digit")
    private String mobileNumber;

    @NotEmpty(message = "Loan type cannot be null or empty")
    private String loanType;

    @PositiveOrZero(message = "Total loan amount must be grater or equal to zero")
    private double totalLoan;

    @PositiveOrZero(message = "Total loan amount paid must be grater or equal to zero")
    private double amountPaid;

    @PositiveOrZero(message = "Total outstanding amount must be grater or equal to zero")
    private double outstandingAmount;

    public Long getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Long loanNumber) {
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
