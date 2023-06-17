package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String organizer;
    private String contactEmail;
    private String contactPhone;
    private AddressDto address;
}
