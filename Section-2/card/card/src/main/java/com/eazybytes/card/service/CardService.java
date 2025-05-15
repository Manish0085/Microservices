package com.eazybytes.card.service;

import com.eazybytes.card.dto.CardDto;

public interface CardService {

    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardsDto);

    boolean deleteCard(String mobileNumber);
}
