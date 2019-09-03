package com.face.sisgerat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.face.sisgerat.service.EmailService;

@SpringBootApplication
public class FaceSisgeratSecurityApplication { //implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FaceSisgeratSecurityApplication.class, args);
	}

	@Autowired
	EmailService service;

//	
//	@Autowired
//	JavaMailSender sender;
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		
//		SimpleMailMessage simple = new SimpleMailMessage();
//		simple.setTo("fundacaodeassistenciaface@gmail.com");
//		simple.setText("email de teste");
//		simple.setSubject("Primeiro email");
//		
//		sender.send(simple);
//		
//	}	

}
