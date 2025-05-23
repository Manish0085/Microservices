package com.eazybytes.loans.service.impl;

import com.eazybytes.loans.constants.LoanConstants;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.exceptions.LoanAlreadyExistsException;
import com.eazybytes.loans.exceptions.ResourceNotFoundException;
import com.eazybytes.loans.mapper.LoanMapper;
import com.eazybytes.loans.repository.LoanRepository;
import com.eazybytes.loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanServiceImpl implements ILoanService {


    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> loan = loanRepository.findByMobileNumber(mobileNumber);
        if (loan.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with the given mobile number "+mobileNumber);
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }



    private Loans createNewLoan(String mobileNumber){
        Loans newLoan = new Loans();
        long randomLoanNumber = 1000000000L + new Random(900000000).nextInt();
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoanConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }


    @Override
    public LoanDto fetchLoanDetails(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDto(loans, new LoanDto());
    }

    @Override
    public boolean updateLoanDetails(LoanDto loanDto) {
        Loans loans = loanRepository.findByMobileNumber(loanDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobile number", loanDto.getMobileNumber())
        );
        LoanMapper.mapToLoan(loanDto, loans);
        loanRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoanEntry(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobile number", mobileNumber)
        );
        loanRepository.deleteById(loans.getLoanId());
        return true;
    }


}
