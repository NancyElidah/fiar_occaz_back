package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.V_StatType;

public interface V_StatTypeRepository extends JpaRepository<V_StatType, Integer> {
    List<V_StatType> findAllByStatus(int status);
}
