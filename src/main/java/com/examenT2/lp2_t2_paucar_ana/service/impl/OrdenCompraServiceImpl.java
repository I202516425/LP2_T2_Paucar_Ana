package com.examenT2.lp2_t2_paucar_ana.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examenT2.lp2_t2_paucar_ana.dto.ResultadoResponse;
import com.examenT2.lp2_t2_paucar_ana.model.OrdenCompraPaucarAna;
import com.examenT2.lp2_t2_paucar_ana.repository.OrdenCompraRepository;
import com.examenT2.lp2_t2_paucar_ana.service.OrdenCompraService;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

	private final OrdenCompraRepository ordenCompraRepository;

	public OrdenCompraServiceImpl(OrdenCompraRepository ordenCompraRepository) {
		this.ordenCompraRepository = ordenCompraRepository;
	}

	@Override
	public List<OrdenCompraPaucarAna> getAll() {
		return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
	}

	@Override
	public OrdenCompraPaucarAna getOne(Integer nroOrden) {
		return ordenCompraRepository.findById(nroOrden).orElse(null);
	}

	@Override
	@Transactional
	public ResultadoResponse create(OrdenCompraPaucarAna ordenCompra) {
		try {
			var registrada = ordenCompraRepository.saveAndFlush(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d registrada.", registrada.getNroOrden());

			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	@Override
	@Transactional
	public ResultadoResponse update(OrdenCompraPaucarAna ordenCompra) {
		try {
			var actualizada = ordenCompraRepository.saveAndFlush(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", actualizada.getNroOrden());

			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
}
