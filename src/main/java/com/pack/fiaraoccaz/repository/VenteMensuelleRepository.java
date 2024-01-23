
package com.pack.fiaraoccaz.repository;

import com.pack.fiaraoccaz.entity.Type;
import com.pack.fiaraoccaz.entity.VenteMensuelle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenteMensuelleRepository extends JpaRepository<VenteMensuelle, Long> {
    List<VenteMensuelle> findByType(Type type);
}
