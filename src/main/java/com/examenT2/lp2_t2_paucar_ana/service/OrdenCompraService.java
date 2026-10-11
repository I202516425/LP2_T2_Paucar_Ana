package com.examenT2.lp2_t2_paucar_ana.service;

import java.util.List;

import com.examenT2.lp2_t2_paucar_ana.dto.ResultadoResponse;
import com.examenT2.lp2_t2_paucar_ana.model.OrdenCompraPaucarAna;

public interface OrdenCompraService {

	List<OrdenCompraPaucarAna> getAll();

	OrdenCompraPaucarAna getOne(Integer nroOrden);

	ResultadoResponse create(OrdenCompraPaucarAna ordenCompra);

	ResultadoResponse update(OrdenCompraPaucarAna ordenCompra);
}
