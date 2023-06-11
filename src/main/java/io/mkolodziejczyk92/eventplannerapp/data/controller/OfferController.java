package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/{id}/offers")
    public List<OfferDto> getOffers(@PathVariable Long id){
        return offerService.getAllOffers(id);
    }

    @GetMapping("/{offerId}")
    public OfferDto getOfferById(@PathVariable Long offerId){
        return offerService.getOfferById(offerId);
    }

    @PostMapping("/offers")
    public void createOffer(@RequestBody OfferDto offerDto){
        offerService.createOffer(offerDto);
    }

    @PutMapping("offers/{id}")
    public void updateOffer(@RequestBody OfferDto offerDto, @PathVariable Long id){
        offerService.updateOffer(id, offerDto);
    }

    @DeleteMapping("offers/{id}")
    public void deleteOffer(@PathVariable Long id){
        offerService.deleteOffer(id);
    }
}
