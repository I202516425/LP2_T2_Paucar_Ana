package com.examenT2.lp2_t2_paucar_ana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.lp2_t2_paucar_ana.model.ProveedorPaucarAna;

public interface ProveedorRepository extends JpaRepository<ProveedorPaucarAna, Integer> {

	List<ProveedorPaucarAna> findAllByOrderByRazonSocialAsc();
}
