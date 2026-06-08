package idat.pe.New_Proyect_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NewProyectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewProyectServerApplication.class, args);
	}

}
