package br.com.sendmail.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Async
	public void sendEmailSimple(SimpleMailMessage mailMessage) {
		sender.send(mailMessage);
		System.out.println("E-mail simples enviado com sucesso.");
	}

	@Async
	public void sendEmailImage(MimeMessage mime, MimeMessageHelper help) {

		Context context = new Context();
		
		System.out.println("E-mail com imagens enviado com sucesso.");
	}
}
