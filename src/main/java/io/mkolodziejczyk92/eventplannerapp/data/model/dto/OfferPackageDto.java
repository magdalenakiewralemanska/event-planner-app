package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferPackageDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private int duration;
    private int maxAmountOfPeople;
    private Boolean isOwnFoodAvailable;
    private Boolean isOwnDrinkAvailable;
    private String specials;
    private String otherDetails;
    private Long offerId;
}
