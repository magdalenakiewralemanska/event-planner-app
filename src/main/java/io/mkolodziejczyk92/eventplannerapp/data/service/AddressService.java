package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;

public interface AddressService {
    Address saveAddress(AddressDto dto);

    void deleteAddress(Long id);

}
