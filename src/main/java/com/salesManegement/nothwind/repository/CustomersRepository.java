package com.salesManegement.nothwind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.salesManegement.nothwind.models.Customer;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, String>{
    
}
