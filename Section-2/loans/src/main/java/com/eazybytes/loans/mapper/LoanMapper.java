package com.eazybytes.loans.mapper;

import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loans;

public class LoanMapper {


    public static LoanDto mapToLoanDto(Loans loan, LoanDto loanDto){
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setTotalLoan(loan.getTotalLoan());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        return loanDto;
    }

    public static Loans mapToLoan(LoanDto loanDto, Loans loans){
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setMobileNumber(loanDto.getMobileNumber());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loans;
    }


}
