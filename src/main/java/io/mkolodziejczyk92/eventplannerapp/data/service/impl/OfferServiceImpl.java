package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.enums.AddressType;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OfferMapperImpl;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.AddressDto;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.AddressService;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapperImpl offerMapper;
    private final OfferRepository repository;
    private final AddressService addressService;

    public OfferServiceImpl(OfferMapperImpl offerMapper, OfferRepository repository, AddressService addressService) {
        this.offerMapper = offerMapper;
        this.repository = repository;
        this.addressService = addressService;
    }

    public void createOffer(OfferDto offerDto) {
        AddressDto addressDto = offerDto.getAddress();
        Address address = addressService.saveAddress(addressDto);
        address.setAddressType(AddressType.RESIDENCE);
        Offer offer = offerMapper.mapToOffer(offerDto);
        offer.setAddress(address);
        repository.save(offer);
        address.setOffer(offer);
    }

    public void deleteOffer(Long id) {
        repository.deleteById(id);
        addressService.deleteAddress(getOfferById(id).getAddress().getId());
    }

    public void updateOffer(Long id, OfferDto offerDto) {

        Optional<Offer> offerOptional = repository.findById(id);
        offerOptional.ifPresentOrElse(offer -> repository.save(offerMapper.mapToOffer(offerDto)), () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    public List<OfferDto> getAllOffersByEventId(Long id) {
        List<Offer> offers = repository.findByEventId(id);
        return offerMapper.mapToOfferDtoList(offers);
    }

    public OfferDto getOfferById(Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer does not exist"));
        return offerMapper.mapToOfferDto(offer);
    }
}
