package com.developer.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * Ejemplo
 * 
 * Con EnableFeignClients, habiliata lso clientes feing y permite inyectar estos 
 * componentes, en clase service, para Autowired
 * 
 * @author rizzoli
 *
 */
@RibbonClient(name = "servicio-productos")
@EnableFeignClients 
@SpringBootApplication
public class SprintbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootServicioItemApplication.class, args);
	}

}
