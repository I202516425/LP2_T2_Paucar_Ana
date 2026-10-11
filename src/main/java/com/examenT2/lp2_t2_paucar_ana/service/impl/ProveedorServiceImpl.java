package com.examenT2.lp2_t2_paucar_ana.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.lp2_t2_paucar_ana.model.ProveedorPaucarAna;
import com.examenT2.lp2_t2_paucar_ana.repository.ProveedorRepository;
import com.examenT2.lp2_t2_paucar_ana.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	private final ProveedorRepository proveedorRepository;

	public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
		this.proveedorRepository = proveedorRepository;
	}

	@Override
	public List<ProveedorPaucarAna> getAll() {
		return proveedorRepository.findAllByOrderByRazonSocialAsc();
	}
}
