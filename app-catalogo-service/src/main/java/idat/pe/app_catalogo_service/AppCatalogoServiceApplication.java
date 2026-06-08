package idat.pe.app_catalogo_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppCatalogoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCatalogoServiceApplication.class, args);
	}

}
