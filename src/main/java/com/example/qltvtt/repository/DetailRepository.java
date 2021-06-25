package com.example.qltvtt.repository;

import com.example.qltvtt.entity.Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends CrudRepository<Detail, Integer> {
}
