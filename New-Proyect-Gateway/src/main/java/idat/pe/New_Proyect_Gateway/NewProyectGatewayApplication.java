package idat.pe.New_Proyect_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NewProyectGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewProyectGatewayApplication.class, args);
	}

}
