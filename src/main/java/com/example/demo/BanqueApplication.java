package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entity.*;
import com.example.demo.Services.*;
import com.example.demo.dao.ClientRepository;


@SpringBootApplication
public class BanqueApplication implements ApplicationRunner {
	
	@Autowired 
	ClientServiceImpl clientservices ;		

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}
	
	public void run(ApplicationArguments args) throws Exception {
       
			
	}
	
	
	
	

}
