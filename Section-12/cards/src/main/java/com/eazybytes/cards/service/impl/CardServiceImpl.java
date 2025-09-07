package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constants.CardConstants;
import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exception.CardAlreadyExistsException;
import com.eazybytes.cards.exception.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardMapper;
import com.eazybytes.cards.repo.CardRepository;
import com.eazybytes.cards.service.ICardService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements ICardService {


    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        if (optionalCard.isPresent()){
            throw new CardAlreadyExistsException("Card Already Registered with the given mobile number: "+mobileNumber);
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber){
        Cards cards = new Cards();
        long cardNumber = 100000000000L + new Random().nextInt(900000000);
        cards.setCardNumber(String.valueOf(cardNumber));
        cards.setMobileNumber(mobileNumber);
        cards.setCardType(CardConstants.CREDIT_CARD);
        cards.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        cards.setAmountUsed(0);
        cards.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return cards;


    }

    @Override
    public CardDto fetachCardDetails(String mobileNumber) {
        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardsDto(cards, new CardDto());
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        Cards cards = cardRepository.findByMobileNumber(cardDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", cardDto.getCardNumber())
        );
        CardMapper.mapToCards(cardDto, cards);
        cardRepository.save(cards);
        return true;
    }

    @Override
    public boolean deleleCard(String mobileNumber) {

        Cards cards = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(cards.getCardId());
        return true;
    }
}
