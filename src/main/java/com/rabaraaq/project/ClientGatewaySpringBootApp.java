package com.rabaraaq.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rabaraaq.project")
public class ClientGatewaySpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(ClientGatewaySpringBootApp.class, args);
	}

}
