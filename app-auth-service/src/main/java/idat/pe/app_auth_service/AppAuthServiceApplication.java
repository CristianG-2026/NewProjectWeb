package idat.pe.app_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAuthServiceApplication.class, args);
	}

}
