package fjavierjp.keepcomponents.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fjavierjp.keepcomponents.backend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}
