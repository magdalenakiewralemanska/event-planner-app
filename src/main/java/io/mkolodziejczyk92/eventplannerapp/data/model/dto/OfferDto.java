package io.mkolodziejczyk92.eventplannerapp.data.model.dto;


import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Order;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OfferDto {


    private Long id;
    private String name;
    private String description;
    private int minAge;
    private int maxAge;
    private String eventType;
    private Set<OfferPackage> offerPackages;
    private Order order;
    private Address address;
}
