package com.developer.item.clientefeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.developer.item.models.Item;
import com.developer.item.models.Producto;

/**
 * Ejemplo de como sondumir servicios de otra forma
 * 
 * Libreria feign forma de implementar rest-template, hace parte de spring-cloud
 * desarrollado por netflix , y se utiliza bastante en micro services
 * 
 * @author santiago betancur
 *
 */

// @FeignClient(name = "servicio-productos", url = "http://localhost:8001/api/producto")
// se implementa con ribbon para balanceo de carga 
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}
