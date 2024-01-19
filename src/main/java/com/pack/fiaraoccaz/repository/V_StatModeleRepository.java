package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.V_StatModele;

public interface V_StatModeleRepository extends JpaRepository<V_StatModele, Integer> {
    List<V_StatModele> findAllByStatus(int status);
}
