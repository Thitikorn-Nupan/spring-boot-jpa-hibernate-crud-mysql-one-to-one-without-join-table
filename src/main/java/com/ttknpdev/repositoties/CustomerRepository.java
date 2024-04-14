package com.ttknpdev.repositoties;

import com.ttknpdev.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> { }
