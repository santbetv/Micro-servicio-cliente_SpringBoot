package com.developer.item.models.servicefeign;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.developer.item.clientefeign.ProductoClienteRest;
import com.developer.item.models.Item;
import com.developer.item.models.service.ItemService;

/**
 * Ejemplo para consumo de tipo Feign
 * 
 * @author rizzoli
 *
 */

//Como se tiene dos servicios dentro del mismo project, se debe de indicar cual es el principal
//luego adicionar nombre al servicio para utlizarlo en el controller con qualifier

// se comenta par seguir utilizando rest template - 1 opcion Primary - 2  con Qualifier
// @Primary
@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {

		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
