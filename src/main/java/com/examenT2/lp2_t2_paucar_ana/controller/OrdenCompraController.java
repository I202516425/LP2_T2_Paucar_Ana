package com.examenT2.lp2_t2_paucar_ana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.lp2_t2_paucar_ana.model.OrdenCompraPaucarAna;
import com.examenT2.lp2_t2_paucar_ana.service.OrdenCompraService;
import com.examenT2.lp2_t2_paucar_ana.service.ProveedorService;
import com.examenT2.lp2_t2_paucar_ana.util.Alert;

@Controller
@RequestMapping("ordencompra")
public class OrdenCompraController {

	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;

	public OrdenCompraController(OrdenCompraService ordenCompraService, ProveedorService proveedorService) {
		this.ordenCompraService = ordenCompraService;
		this.proveedorService = proveedorService;
	}

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraService.getAll());
		return "listadoPaucarAna";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", new OrdenCompraPaucarAna());
		return "nuevoPaucarAna";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraPaucarAna ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.create(ordenCompra);
		flash.addFlashAttribute("alert",
				Alert.sweetToast(response.mensaje(), response.success() ? "success" : "error", 5000));

		return "redirect:/ordencompra/listado";
	}

	@GetMapping("edicion/{nroOrden}")
	public String edicion(@PathVariable Integer nroOrden, Model model, RedirectAttributes flash) {
		var ordenCompra = ordenCompraService.getOne(nroOrden);

		if (ordenCompra == null) {
			flash.addFlashAttribute("alert", Alert.sweetToast("Orden de compra no encontrada", "error", 5000));
			return "redirect:/ordencompra/listado";
		}

		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("ordenCompra", ordenCompra);
		return "edicionPaucarAna";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraPaucarAna ordenCompra, RedirectAttributes flash) {
		var response = ordenCompraService.update(ordenCompra);
		flash.addFlashAttribute("alert",
				Alert.sweetToast(response.mensaje(), response.success() ? "success" : "error", 5000));

		return "redirect:/ordencompra/listado";
	}
}
