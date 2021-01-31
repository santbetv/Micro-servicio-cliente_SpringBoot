package com.developer.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.developer.item.models.Item;
import com.developer.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		
		
		
		List<Producto> productos = Arrays.asList(  clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		
		/**
		 * Los objetos de tipo List tienen los metodos stream para convertir la lista en un flujo
		 * Con map cambiamos cada elemento del flujo, (converti producto a item)
		 * con lambda  
		 * collet (coverti el string a un list)
		 * 
		 * Se realiza con este programación funcional.
		 * 
		 */
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
		
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		//para poder pasar su parametro y valor, con el fin de saber que buscar
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
		//indica api , los datos a capturar, la variables a buscar
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		
		return new Item(producto, cantidad);
	}

}
