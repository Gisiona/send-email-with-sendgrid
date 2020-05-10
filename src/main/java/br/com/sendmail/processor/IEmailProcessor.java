package br.com.sendmail.processor;

import javax.mail.MessagingException;

import org.springframework.scheduling.annotation.Async;

import br.com.sendmail.dto.EmailDto;

public interface IEmailProcessor {
	
	@Async
	void sendEmailSimple(EmailDto email);
	
	@Async
	void sendEmailImage(EmailDto email) throws MessagingException;
}
