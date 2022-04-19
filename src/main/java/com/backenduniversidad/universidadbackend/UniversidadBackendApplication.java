package com.backenduniversidad.universidadbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversidadBackendApplication {

	public static void main(String[] args) {
		String[] beans = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();

//		for (String b: beans) {
//			System.out.println(b);
//		}
	}

}
