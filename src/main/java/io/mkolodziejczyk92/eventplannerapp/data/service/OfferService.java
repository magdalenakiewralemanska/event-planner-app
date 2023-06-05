package io.mkolodziejczyk92.eventplannerapp.data.service;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import io.mkolodziejczyk92.eventplannerapp.utils.OfferMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    public OfferDto saveOffer(OfferDto offerDto) {
        Offer offer = offerRepository.save(offerMapper.mapToOffer(offerDto));
        return offerMapper.mapToOfferDto(offer);
    }

    public List<OfferDto> getAllOffers() {
        return offerMapper.mapToOfferDtoList(
                offerRepository.findAll());
    }

    public void updateOfferById(Long id, OfferDto offerDto) {
        Optional<Offer> offerOptional = offerRepository.findById(id);
        offerOptional.ifPresentOrElse(offer -> {
            offer.setName(offerDto.getName());
            offer.setDescription(offerDto.getDescription());
            offer.setMinAge(offerDto.getMinAge());
            offer.setMaxAge(offerDto.getMaxAge());
            offer.setAddress(offerDto.getAddress());
            offer.setEventType(offerDto.getEventType());
            offer.setOfferPackages(offerDto.getOfferPackages());
            offer.setOrder(offerDto.getOrder());
            offerRepository.save(offer);
        }, () -> {
            throw new EntityNotFoundException("Offer id: " + id + " not found");
        });
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

}
