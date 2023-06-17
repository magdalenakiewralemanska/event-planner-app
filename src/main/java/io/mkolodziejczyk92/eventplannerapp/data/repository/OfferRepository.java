package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findByEventId(Long eventId);
}
