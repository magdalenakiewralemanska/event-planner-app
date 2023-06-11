package io.mkolodziejczyk92.eventplannerapp.data.mapper;


import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;

import java.util.List;


public interface OfferMapper {

    OfferDto mapToOfferDto(Offer offer);

    Offer mapToOffer(OfferDto offerDto);

    List<OfferDto> mapToOfferDtoList(List<Offer> offers);
}
