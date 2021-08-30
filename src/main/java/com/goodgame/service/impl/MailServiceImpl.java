package com.goodgame.service.impl;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.goodgame.service.MailService;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("ducnguyen2394@gmail.com", "goodgame");
	    helper.setTo(recipientEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
		
	}

}
