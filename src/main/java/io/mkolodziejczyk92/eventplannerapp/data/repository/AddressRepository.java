package io.mkolodziejczyk92.eventplannerapp.data.repository;

import io.mkolodziejczyk92.eventplannerapp.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
