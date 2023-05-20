package com.salesManegement.nothwind.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.salesManegement.nothwind.models.Order;
import com.salesManegement.nothwind.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Procedure(name = "SelectThe5ProductsWithLessQuantity")
    List<Product> selectThe5ProductsWithLessQuantity();
}
