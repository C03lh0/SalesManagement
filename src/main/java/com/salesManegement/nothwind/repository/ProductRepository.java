package com.salesManegement.nothwind.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesManegement.nothwind.models.Order;
import com.salesManegement.nothwind.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    //Iterable<Product> findByOrder(Order order);
}
