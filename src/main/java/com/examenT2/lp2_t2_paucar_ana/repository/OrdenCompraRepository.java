package com.examenT2.lp2_t2_paucar_ana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenT2.lp2_t2_paucar_ana.model.OrdenCompraPaucarAna;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraPaucarAna, Integer> {

	// Listado descendente por número de orden
	List<OrdenCompraPaucarAna> findAllByOrderByNroOrdenDesc();
}
