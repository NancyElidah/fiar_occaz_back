package com.pack.fiaraoccaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Integer> {
    
}
