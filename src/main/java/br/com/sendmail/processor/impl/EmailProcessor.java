package br.com.sendmail.processor.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import br.com.sendmail.dto.EmailDto;
import br.com.sendmail.processor.IEmailProcessor;
import br.com.sendmail.service.EmailService;

@Component
public class EmailProcessor implements IEmailProcessor {

	@Autowired
	private EmailService emailService;

	@Override
	public void sendEmailSimple(EmailDto email) {
		SimpleMailMessage mensagem = new SimpleMailMessage();
		
		mensagem.setFrom(email.getFrom());
		mensagem.setTo(email.getTo());
		mensagem.setSubject(email.getSubject());
		mensagem.setText(email.getMessage());
		
		System.out.println("Enviando email simples.");
		
		emailService.sendEmailSimple(mensagem);
	}

	@Override
	public void sendEmailImage(EmailDto email) throws MessagingException {
		MimeMessage mime = null;
		
		MimeMessageHelper help = new MimeMessageHelper(mime, true, "UTF-8"); 
		help.setFrom(email.getFrom());
		help.setTo(email.getTo());
		help.setSubject(email.getSubject());
		help.setText(email.getMessage(), true);
		
		System.out.println("Enviando email com imagens.");
		emailService.sendEmailImage(mime, help);		
	}
}
