package com.reto.actuator.RetoActuator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RetoActuatorApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RetoActuatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ServiceStatus service = new ServiceStatus();
		
		for (int i = 0; i < 5; i++) {
			
			
			if (i < 4) {
				service.statusOpen();
				service.statusPause();
				Thread.sleep(1000);
			}
			
			if (i == 4) {
				service.statusClose();
			}

			

		}
		
	}

}
