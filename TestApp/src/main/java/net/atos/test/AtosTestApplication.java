package net.atos.test;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtosTestApplication {

	
	  @Bean 
	  public ModelMapper modelMapper() { 
		  return new ModelMapper();
	  }
	 
	
	public static void main(String[] args) {
		SpringApplication.run(AtosTestApplication.class, args);
	}

}
