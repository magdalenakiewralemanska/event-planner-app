package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public void createOffer(@RequestBody OfferDto offerDto) {
        OfferDto savedOffer = offerService.saveOffer(offerDto);
    }

    @GetMapping
    public List<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PutMapping("/{id}")
    public void updateOfferById(@RequestBody OfferDto offerDto, @PathVariable Long id) {
        offerService.updateOfferById(id, offerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferById(@PathVariable Long id) {
        offerService.deleteOffer(id);
    }
}
