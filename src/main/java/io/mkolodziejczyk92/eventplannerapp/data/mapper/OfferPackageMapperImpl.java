package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferPackageMapperImpl implements OfferPackageMapper{

    private final OfferRepository offerRepository;

    public OfferPackageMapperImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferPackageDto mapToOfferPackageDto(OfferPackage offerPackage) {
        if ( offerPackage == null ) {
            return null;
        }

        OfferPackageDto offerPackageDto = new OfferPackageDto();

        offerPackageDto.setId(offerPackage.getId());
        offerPackageDto.setTitle( offerPackage.getTitle() );
        offerPackageDto.setDescription( offerPackage.getDescription() );
        offerPackageDto.setPrice( offerPackage.getPrice() );
        offerPackageDto.setDuration( offerPackage.getDuration() );
        offerPackageDto.setMaxAmountOfPeople( offerPackage.getMaxAmountOfPeople());
        offerPackageDto.setIsOwnFoodAvailable( offerPackage.getIsOwnFoodAvailable());
        offerPackageDto.setIsOwnDrinkAvailable( offerPackage.getIsOwnDrinkAvailable());
        offerPackageDto.setSpecials( offerPackage.getSpecials() );
        offerPackageDto.setOtherDetails(offerPackage.getOtherDetails());
        offerPackageDto.setOfferId( offerPackage.getOffer().getId() );

        return offerPackageDto;
    }

    @Override
    public OfferPackage mapToOfferPackage(OfferPackageDto offerPackageDto) {
        if ( offerPackageDto == null ) {
            return null;
        }

        OfferPackage offerPackage = new OfferPackage();

        offerPackage.setTitle( offerPackageDto.getTitle() );
        offerPackage.setDescription( offerPackageDto.getDescription() );
        offerPackage.setPrice( offerPackageDto.getPrice() );
        offerPackage.setDuration( offerPackageDto.getDuration() );
        offerPackage.setMaxAmountOfPeople( offerPackageDto.getMaxAmountOfPeople() );
        offerPackage.setIsOwnFoodAvailable( offerPackageDto.getIsOwnFoodAvailable());
        offerPackage.setIsOwnDrinkAvailable( offerPackageDto.getIsOwnDrinkAvailable());
        offerPackage.setSpecials( offerPackageDto.getSpecials() );
        offerPackage.setOtherDetails(offerPackageDto.getOtherDetails());
        offerPackage.setOffer(offerRepository.findById(offerPackageDto.getOfferId()).get());

        return offerPackage;
    }

    @Override
    public List<OfferPackageDto> mapToOfferPackageDtoList(List<OfferPackage> packages) {
        if ( packages == null ) {
            return null;
        }

        List<OfferPackageDto> list = new ArrayList<>( packages.size() );
        for ( OfferPackage offerPackage : packages ) {
            list.add( mapToOfferPackageDto( offerPackage ) );
        }

        return list;
    }
}
