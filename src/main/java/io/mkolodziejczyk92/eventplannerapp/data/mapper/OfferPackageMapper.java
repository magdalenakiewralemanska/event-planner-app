package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;

import java.util.List;


public interface OfferPackageMapper {

    OfferPackageDto mapToOfferPackageDto(OfferPackage offerPackage);

    OfferPackage mapToOfferPackage(OfferPackageDto offerPackageDto);

    List<OfferPackageDto> mapToOfferPackageDtoList(List<OfferPackage> packages);
}
