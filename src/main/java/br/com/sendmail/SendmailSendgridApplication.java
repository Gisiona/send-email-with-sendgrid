package br.com.sendmail;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendmailSendgridApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendmailSendgridApplication.class, args);
	}

	@PostConstruct
	public void init() {
	}
}
