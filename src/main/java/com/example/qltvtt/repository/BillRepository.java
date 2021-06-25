package com.example.qltvtt.repository;

import com.example.qltvtt.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
}
