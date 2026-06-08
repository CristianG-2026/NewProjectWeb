package idat.pe.app_carrito_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppCarritoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCarritoServiceApplication.class, args);
	}

}
