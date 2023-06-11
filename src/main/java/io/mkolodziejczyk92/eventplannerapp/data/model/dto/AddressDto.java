package io.mkolodziejczyk92.eventplannerapp.data.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AddressDto {

    private Long id;
    private String street;
    private String city;
    private String houseNumber;
    private String apartmentNumber;
    private String zipCode;
}
