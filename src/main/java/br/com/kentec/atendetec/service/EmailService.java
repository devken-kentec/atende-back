package br.com.kentec.atendetec.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void enviar() {
		SimpleEmail email = new SimpleEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.outlook.com" );
		email.setSslSmtpPort( "465" );
		email.setAuthenticator( new DefaultAuthenticator( "kennedy_tomazete@outlook.com" ,  "senha" ) );
		try {
		    email.setFrom( "kennedy_tomazete@outlook.com");
		     
		    email.setDebug(true); 
		     
		    email.setSubject( "Assunto do E-mail" );
		    email.setMsg( "Texto sem formatação" );
		    email.addTo( "kennedytomazete@gmail.com" );//por favor trocar antes de testar!!!!
		     
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
}
