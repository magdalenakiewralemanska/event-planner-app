package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;

import java.util.List;


public interface OfferPackageService {


    List<OfferPackageDto> getAllOfferPackagesByOfferId(Long offerId);

    OfferPackageDto getPackageById(Long id);

}
