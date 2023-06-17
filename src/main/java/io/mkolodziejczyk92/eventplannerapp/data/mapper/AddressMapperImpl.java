package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper{

    @Override
    public AddressDto mapToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setStreet(address.getStreet());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setApartmentNumber(address.getApartmentNumber());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setCity(address.getCity());
        return addressDto;
    }

    @Override
    public Address mapToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setApartmentNumber(addressDto.getApartmentNumber());
        address.setZipCode(addressDto.getZipCode());
        address.setCity(addressDto.getCity());
        return address;
    }
}
