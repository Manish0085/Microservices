package com.eazybytes.loans.service;

import com.eazybytes.loans.dto.LoanDto;

public interface ILoanService {

    void createLoan(String mobileNumber);

    LoanDto fetchLoanDetails(String mobileNumber);

    boolean updateLoanDetails(LoanDto loanDto);

    boolean deleteLoanEntry(String mobileNumber);
}
