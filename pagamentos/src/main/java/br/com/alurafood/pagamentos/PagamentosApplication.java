package br.com.alurafood.pagamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Com essa anotação, é possivel declarar interfaces de cliente que o Feign automaticamente implementa em tempo de execução, realizando chamadas HTTP para serviços remotos de forma transparente.
@SpringBootApplication
@EnableDiscoveryClient
public class PagamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentosApplication.class, args);
	}

}