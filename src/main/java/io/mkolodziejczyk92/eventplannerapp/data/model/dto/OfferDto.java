package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto {

    private Long id;
    private String name;
    private int minAge;
    private int maxAge;
    private String description;
    private Long eventId;
    private List<OfferPackage> offerPackages;
    private Address address;
}
