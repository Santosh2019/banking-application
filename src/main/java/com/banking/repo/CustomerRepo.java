package com.banking.repo;

import com.banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    Optional<Customer> findByAadharNumber(String aadharNumber);

    Optional<Customer> findByEmailId(String emailId);

    Optional<Customer> findByPhoneNumber(String phoneNumber);
}
