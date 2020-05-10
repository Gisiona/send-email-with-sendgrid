package br.com.sendmail.dto.response;

public class EmailResponseDto {

	public EmailResponseDto(String ticket, String mensagem) {
		this.ticket = ticket;
		this.mensagem = mensagem;
	}

	private String ticket;
	private String mensagem;
	
	public String getTicket() {
		return ticket;
	}
	
	public String getMensagem() {
		return mensagem;
	}
}
