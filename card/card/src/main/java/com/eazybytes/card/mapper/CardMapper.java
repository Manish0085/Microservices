package com.eazybytes.card.mapper;

import com.eazybytes.card.dto.CardDto;
import com.eazybytes.card.entity.Cards;

public class CardMapper {

    public static Cards mapToCard(CardDto cardDto, Cards card){

        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        return card;
    }

    public static CardDto mapToCardDto(Cards card, CardDto cardDto){

        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        return cardDto;
    }
}
