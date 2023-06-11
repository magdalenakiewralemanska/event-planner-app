package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;

import java.util.List;

public interface OfferService {

    OfferDto createOffer(OfferDto offerDto);
    void deleteOffer(Long id) ;
    void updateOffer(Long id, OfferDto offerDto);
    List<OfferDto> getAllOffers(Long id);
    OfferDto getOfferById(Long id);
}
