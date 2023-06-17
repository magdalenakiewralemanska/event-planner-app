package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.AddressMapperImpl;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.AddressRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapperImpl addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapperImpl addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public Address saveAddress(AddressDto dto){
        Address newAddress = addressMapper.mapToAddress(dto);
        return addressRepository.save(newAddress);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
