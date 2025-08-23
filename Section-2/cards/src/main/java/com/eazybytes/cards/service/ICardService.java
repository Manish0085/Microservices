package com.eazybytes.cards.service;

import com.eazybytes.cards.dto.CardDto;

public interface ICardService {

    void createCard(String mobileNumber);

    CardDto fetachCardDetails(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleleCard(String mobileNumber);
}
