package com.eazybytes.cards.controller;

import com.eazybytes.cards.constants.CardConstants;
import com.eazybytes.cards.dto.CardDto;
import com.eazybytes.cards.dto.ResponseDto;
import com.eazybytes.cards.service.ICardService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;

@RestController
@RequestMapping("/api")
public class CardController {

    private ICardService iCardService;

    public CardController(ICardService iCardService){
        this.iCardService = iCardService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber){
        iCardService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }


    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam String mobileNumber){
        CardDto cardDto = iCardService.fetachCardDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cardDto);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> upadteCardDetails(@RequestBody CardDto cardDto){
        boolean isUpdated = iCardService.updateCard(cardDto);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardConstants.STATUS_500, CardConstants.MESSAGE_500));
        }
    }

    @PutMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam String mobileNumber){
        boolean isDeleted = iCardService.deleleCard(mobileNumber);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(CardConstants.STATUS_500, CardConstants.MESSAGE_500));
        }
    }

}
