package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.V_StatMarque;

public interface V_StatMarqueRepository extends JpaRepository<V_StatMarque, Integer>{
    List<V_StatMarque> findAllByStatus(int status);
}
