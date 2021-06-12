package br.org.serratec.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/*
 * precisa de uma dependencia para email		- JAVA MAIL SENDER
 */
@Configuration
public class MailConfig {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviarEmail (String para, String assunto, String texto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("vanessa.wendling@estudante.firjan.senai.br");
		simpleMailMessage.setTo(para);
		simpleMailMessage.setSubject(assunto);
		simpleMailMessage.setText("Dados do Usuário:\n" + texto + "\n\n\n\n Serratec Residência de Software - 2021");
		javaMailSender.send(simpleMailMessage);
	}
}
