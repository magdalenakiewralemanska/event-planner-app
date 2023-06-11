package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OfferMapperImpl;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.EventRepository;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferService;
import jakarta.persistence.EntityNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferMapperImpl offerMapperImpl;
    private final OfferRepository repository;

    private final EventRepository eventRepository;

    public OfferServiceImpl(OfferMapperImpl offerMapperImpl, OfferRepository repository, EventRepository eventRepository) {
        this.offerMapperImpl = offerMapperImpl;
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public OfferDto createOffer(OfferDto offerDto) {
        Offer offer = new Offer();

                repository.save(offerMapperImpl.mapToOffer(offerDto));
        return offerMapperImpl.mapToOfferDto(offer);

    }

    public void deleteOffer(Long id) {
        repository.deleteById(id);
    }
    public void updateOffer(Long id, OfferDto offerDto) {

        Optional<Offer> offerOptional = repository.findById(id);
        offerOptional.ifPresentOrElse(offer -> {
            offer.setName(offerDto.getName());
            repository.save(offer);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }

    public List<OfferDto> getAllOffers(Long id) {
        List<Offer> offers = filterOfferByEventId(id);
        return offerMapperImpl.mapToOfferDtoList(offers);
    }

    @NotNull
    private List<Offer> filterOfferByEventId(Long id) {
        return eventRepository
                .findAll()
                .stream()
                .flatMap(event -> event
                        .getOffers()
                        .stream())
                .filter(offer -> Objects.equals(offer
                        .getEvent()
                        .getId(), id))
                .toList();
    }

    public OfferDto getOfferById(Long id) {
        Offer offer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer does not exist"));
        return offerMapperImpl.mapToOfferDto(offer);
    }
}
