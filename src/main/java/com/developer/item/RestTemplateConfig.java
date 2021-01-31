package com.developer.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * Caractersiticas creamos componentes desde el beans y los podemos registrar en el contenedor 
 * utilizando metodos y la anotacion beans.
 * 
 * Componente rest template Se debe de configurar como un componente de spring para que 
 * quede guardado en el contenedor de spring y lo podomos inyectar en el contenedor de la clase.
 * 
 * El fin de este es: Cliente HTTP para trabajar con Api Rest y poder acceder a recursos
 * que estan en otros servicios.
 * 
 * @return
 */
@Configuration
public class RestTemplateConfig {
	
	@Bean("clienteRest")
	@LoadBalanced //anotacion que permite balanceo de carga en rest-template
	public RestTemplate registrarRestTeamplate() {
		return  new RestTemplate();
	}
	
	//El objeto que se retorna se guarda en el contenedor con la anotacion Bean
	
}
