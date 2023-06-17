package io.mkolodziejczyk92.eventplannerapp.data.mapper;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.EventRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfferMapperImpl implements OfferMapper {

    private final EventRepository eventRepository;
    private final AddressMapperImpl addressMapper;

    public OfferMapperImpl(EventRepository eventRepository, AddressMapperImpl addressMapper) {
        this.eventRepository = eventRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public OfferDto mapToOfferDto(Offer offer) {
        if ( offer == null ) {
            return null;
        }

        OfferDto offerDto = new OfferDto();

        offerDto.setId( offer.getId() );
        offerDto.setName( offer.getName() );
        offerDto.setMinAge( offer.getMinAge() );
        offerDto.setMaxAge( offer.getMaxAge() );
        offerDto.setDescription( offer.getDescription() );
        offerDto.setOrganizer(offer.getOrganizer());
        offerDto.setContactEmail(offer.getContactEmail());
        offerDto.setContactPhone(offer.getContactPhone());
        offerDto.setEventId( offer.getEvent().getId());
        offerDto.setAddress( addressMapper.mapToAddressDto(offer.getAddress()) );

        return offerDto;
    }

    @Override
    public Offer mapToOffer(OfferDto offerDto) {
        if (offerDto == null) {
            return null;
        }

        Offer offer = new Offer();
        offer.setName(offerDto.getName());
        offer.setMinAge(offerDto.getMinAge());
        offer.setMaxAge(offerDto.getMaxAge());
        offer.setDescription(offerDto.getDescription());
        offer.setOrganizer(offerDto.getOrganizer());
        offer.setContactEmail(offerDto.getContactEmail());
        offer.setContactPhone(offerDto.getContactPhone());
        offer.setEvent(eventRepository.findById(offerDto.getEventId()).get());
        offer.setAddress(addressMapper.mapToAddress(offerDto.getAddress()));

        return offer;
    }

    public List<OfferDto> mapToOfferDtoList(List<Offer> offers) {
        if ( offers == null ) {
            return null;
        }

        List<OfferDto> list = new ArrayList<>( offers.size() );
        for ( Offer offer : offers ) {
            list.add( mapToOfferDto( offer ) );
        }

        return list;
    }
}
