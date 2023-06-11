package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.enums.AddressType;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.AddressRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address saveAddress(AddressDto dto){
        Address newAddress = new Address();
        newAddress.setStreet(dto.getStreet());
        newAddress.setHouseNumber(dto.getHouseNumber());
        newAddress.setApartmentNumber(dto.getApartmentNumber());
        newAddress.setStreet(dto.getStreet());
        newAddress.setZipCode(dto.getZipCode());
        newAddress.setCity(dto.getCity());
        newAddress.setAddressType(AddressType.RESIDENCE);
        return addressRepository.save(newAddress);
    }
}
