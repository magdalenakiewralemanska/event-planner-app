package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;

import java.util.List;

public interface OfferService {

    void createOffer(OfferDto offerDto);
    void deleteOffer(Long id) ;
    void updateOffer(Long id, OfferDto offerDto);
    List<OfferDto> getAllOffersByEventId(Long id);
    OfferDto getOfferById(Long id);
}
