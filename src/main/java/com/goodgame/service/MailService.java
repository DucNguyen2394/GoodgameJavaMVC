package com.goodgame.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public interface MailService {
	void sendMail(String recipientEmail, String link) throws UnsupportedEncodingException, MessagingException;
}
