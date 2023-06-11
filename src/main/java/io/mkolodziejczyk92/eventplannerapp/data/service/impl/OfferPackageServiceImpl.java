package io.mkolodziejczyk92.eventplannerapp.data.service.impl;

import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import io.mkolodziejczyk92.eventplannerapp.data.mapper.OfferPackageMapper;
import io.mkolodziejczyk92.eventplannerapp.data.model.dto.OfferPackageDto;
import io.mkolodziejczyk92.eventplannerapp.data.repository.OfferPackageRepository;
import io.mkolodziejczyk92.eventplannerapp.data.service.OfferPackageService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
