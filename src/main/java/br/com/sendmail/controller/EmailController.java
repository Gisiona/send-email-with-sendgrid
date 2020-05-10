package br.com.sendmail.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sendmail.dto.EmailDto;
import br.com.sendmail.dto.response.EmailResponseDto;
import br.com.sendmail.processor.IEmailProcessor;

@RestController
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private IEmailProcessor emailProcessor;
	
	@Autowired
	private Environment env;
	
	@PostMapping("/simples")
	private ResponseEntity<EmailResponseDto> sendEmail(@Valid @RequestBody EmailDto email){
		emailProcessor.sendEmailSimple(email);
		 		
		UUID uuid = UUID.randomUUID();
		String ticket = uuid.toString();
		EmailResponseDto response = new EmailResponseDto(ticket, "E-mail enviado com sucesso.");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	private ResponseEntity<String> getHome(){
		String host = env.getProperty("spring.mail.host");
		String user = env.getProperty("spring.mail.username");
		String pass = env.getProperty("spring.mail.password");
		
		return ResponseEntity.status(HttpStatus.OK).body(String.format("HOST: %s, USER: %s, PASS: %s",host, user, pass));
	}
}
