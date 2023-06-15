package io.mkolodziejczyk92.eventplannerapp.data.controller;

import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferPackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfferPackageController {

    private final OfferPackageService packageService;

    public OfferPackageController(OfferPackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("offers/{offerId}")
    public List<OfferPackageDto> getPackages(@PathVariable Long offerId){
        return packageService.getAllOfferPackagesByOfferId(offerId);
    }

    @GetMapping("packageDetails/{packageId}")
    public OfferPackageDto getOfferPackageById(@PathVariable Long packageId){
        return packageService.getPackageById(packageId);
    }

    @PostMapping("/package")
    public void createPackage(@RequestBody OfferPackageDto offerPackageDto){
        packageService.createPackage(offerPackageDto);
    }

    @PutMapping("/{id}")
    public void updatePackage(@RequestBody OfferPackageDto offerPackageDto, @PathVariable Long id){
        packageService.updatePackage(id, offerPackageDto);
    }

    @DeleteMapping("/{id}")
    public void deletePackage(@PathVariable Long id){
        packageService.deletePackage(id);
    }
}
