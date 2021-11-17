package com.reto.actuator.RetoActuator;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ServiceStatus {
	Logger logger = LoggerFactory.getLogger(ServiceStatus.class);
	
	RestTemplate template = new RestTemplate();
	
	String URL = "http://localhost:8080/";
	
	Coche micoche;
	
	public ServiceStatus() throws URISyntaxException{
		micoche = new Coche();
		micoche.setModelo("HYUNDAI");
		
		statusClose();
	}
	
	public void statusOpen() throws URISyntaxException{
		String openURL  = URL + "actuator/open";
		micoche.setStatus("OPEN");
		URI uri = new URI(openURL);
		ResponseEntity<String> response = template.postForEntity(uri,micoche ,String.class);
		logger.info("OPEN");
		
	}
	
	public void statusClose() throws URISyntaxException {
		String closeURL = URL + "actuator/close";
		micoche.setStatus("CLOSE");
		URI uri = new URI(closeURL);
		ResponseEntity<String> response = template.postForEntity(uri,micoche ,String.class);
		logger.info("CLOSE");
	}
	
	public void statusPause() throws URISyntaxException {
		String pauseURL = URL + "actuator/pause";
		micoche.setStatus("PAUSE");
		URI uri = new URI(pauseURL);
		ResponseEntity<String> response = template.postForEntity(uri,micoche ,String.class);
		logger.info("PAUSE");
	}
}
