package idat.pe.app_notificacion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppNotificacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppNotificacionServiceApplication.class, args);
	}

}
