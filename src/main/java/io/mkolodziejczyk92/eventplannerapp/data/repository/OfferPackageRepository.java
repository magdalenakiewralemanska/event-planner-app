package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.OfferPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferPackageRepository extends JpaRepository<OfferPackage, Long> {

    List<OfferPackage> findByOfferId(Long offerId);
}
