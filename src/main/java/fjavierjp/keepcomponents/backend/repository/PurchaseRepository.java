package fjavierjp.keepcomponents.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fjavierjp.keepcomponents.backend.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
