package fjavierjp.keepcomponents.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fjavierjp.keepcomponents.backend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	@Query(
		value = "SELECT * FROM customers WHERE name REGEXP :pattern OR surname REGEXP :pattern OR email REGEXP :pattern",
		countQuery = "SELECT count(*) FROM customers WHERE name REGEXP :pattern OR surname REGEXP :pattern OR email REGEXP :pattern",
		nativeQuery = true)
	public Page<Customer> findAllByRegex(@Param("pattern") String pattern, Pageable pageable);
}
