package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events/{id}/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping()
    public List<OfferDto> getOffers(@PathVariable Long id){
        return offerService.getAllOffers(id);
    }

    @GetMapping("/{offerId}")
    public OfferDto getOfferById(@PathVariable Long offerId){
        return offerService.getOfferById(offerId);
    }

    @PostMapping()
    public void createOffer(@RequestBody OfferDto offerDto){
        offerService.createOffer(offerDto);
    }

    @PutMapping("{offerId}")
    public void updateOffer(@RequestBody OfferDto offerDto, @PathVariable Long offerId){
        offerService.updateOffer(offerId, offerDto);
    }

    @DeleteMapping("{offerId}")
    public void deleteOffer(@PathVariable Long offerId){
        offerService.deleteOffer(offerId);
    }
}
