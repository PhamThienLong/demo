package com.example.qltvtt.repository;

import com.example.qltvtt.entity.Account;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
