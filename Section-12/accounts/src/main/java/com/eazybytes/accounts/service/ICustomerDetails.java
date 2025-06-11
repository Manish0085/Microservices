package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface ICustomerDetails {


    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
