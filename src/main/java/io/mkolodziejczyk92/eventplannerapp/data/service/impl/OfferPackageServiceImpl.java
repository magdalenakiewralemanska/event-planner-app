package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OfferPackageMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferPackageRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferPackageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferPackageServiceImpl implements OfferPackageService {

    private final OfferPackageMapper packageMapper;
    private final OfferPackageRepository repository;

    public OfferPackageServiceImpl(OfferPackageMapper packageMapper, OfferPackageRepository repository) {
        this.packageMapper = packageMapper;
        this.repository = repository;
    }

    @Override
    public List<OfferPackageDto> getAllOfferPackagesByOfferId(Long offerId) {
        List<OfferPackage> packages = repository.findByOfferId(offerId);
        return packageMapper.mapToOfferPackageDtoList(packages);
    }

    @Override
    public OfferPackageDto getPackageById(Long id) {
        OfferPackage offerPackage = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package does not exist"));
        return packageMapper.mapToOfferPackageDto(offerPackage);
    }

    @Override
    public OfferPackageDto createPackage(OfferPackageDto offerPackageDto) {
        OfferPackage offerPackage = repository.save(packageMapper.mapToOfferPackage(offerPackageDto));
        return packageMapper.mapToOfferPackageDto(offerPackage);
    }

    @Override
    public void deletePackage(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updatePackage(Long id, OfferPackageDto offerPackageDto) {
        Optional<OfferPackage> packageOptional = repository.findById(id);
        packageOptional.ifPresentOrElse(offerPackage -> {
            offerPackage.setTitle(offerPackageDto.getTitle());
            offerPackage.setDescription(offerPackageDto.getDescription());
            offerPackage.setDuration(offerPackageDto.getDuration());
            offerPackage.setPrice(offerPackageDto.getPrice());
            offerPackage.setSpecials(offerPackageDto.getSpecials());
            offerPackage.setOtherDetails(offerPackageDto.getOtherDetails());
            offerPackage.setMaxAmountOfPeople(offerPackageDto.getMaxAmountOfPeople());
            offerPackage.setIsOwnDrinkAvailable(offerPackageDto.getIsOwnDrinkAvailable());
            offerPackage.setIsOwnFoodAvailable(offerPackageDto.getIsOwnFoodAvailable());
            repository.save(offerPackage);
        }, () -> {
            throw new EntityNotFoundException("Entity id: " + id + " not found");
        });
    }
}
