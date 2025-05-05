package com.eazybytes.loans.controller;

import com.eazybytes.loans.constants.LoanConstants;
import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.dto.ResponseDto;
import com.eazybytes.loans.entity.Loans;
import com.eazybytes.loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;

@RestController
@RequestMapping("/api/loan")
public class LoanController {


    @Autowired
    private ILoanService iLoanService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam String mobileNumber){
        iLoanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));

    }

    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestParam String mobileNumber){
        LoanDto loanDto = iLoanService.fetchLoanDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@RequestBody LoanDto loanDto){
        boolean isUpdated = iLoanService.updateLoanDetails(loanDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417,  LoanConstants.MESSAGE_417_UPDATE))
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<ResponseDto> deleteLoanEntry(@RequestParam String mobileNumber){
        boolean isUpdated = iLoanService.deleteLoanEntry(mobileNumber);
        if (isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200)
            );
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE))
        }
    }

}
