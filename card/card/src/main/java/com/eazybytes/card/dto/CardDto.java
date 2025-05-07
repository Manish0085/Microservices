package com.eazybytes.card.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(
        name = "Cards",
        description = "Customer Card details "
)
public class CardDto {

    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "^$[0-9]{10}", message = "Mobile number must be 10 digits")
    @Schema(
            description = "Mobile number of Customer", example = "6214585001"
    )
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be null or empty")
    @Pattern(regexp = "^$[0-9]{12}", message = "Card number must be 12 digits")
    @Schema(
            description = "Customer's Card Number", example = "145298771236"
    )
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be null")
    @Schema(
            description = "Type of the Card", example = "Debit Card"
    )
    private String cardType;

    @Positive(message = "Total limit should be greater then zero")
    @Schema(
            description = "Total limit available against card", example = "100000"
    )
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater then zero")
    @Schema(
            description = "Total amount used by a Customer", example = "1000"
    )
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater then zero")
    @Schema(
            description = "Total available amount against a card", example = "90000"
    )
    private int availableAmount;


}
