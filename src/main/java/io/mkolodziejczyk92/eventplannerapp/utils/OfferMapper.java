package io.mkolodziejczyk92.eventplannerapp.utils;


import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferDto mapToOfferDto(Offer offer);

    @InheritInverseConfiguration
    Offer mapToOffer(OfferDto offerDto);

    List<OfferDto> mapToOfferDtoList(List<Offer> offers);

    @InheritInverseConfiguration
    List<Offer> mapToOfferList(List<OfferDto> offersDto);


}
