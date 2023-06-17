package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;

public interface AddressMapper {

    AddressDto mapToAddressDto(Address address);

    Address mapToAddress(AddressDto addressDto);
}
