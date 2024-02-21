package com.example.count.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.example.count.model.Mail;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("$(spring.mail.username)")
	private String frommail;
	
	public void sendMail(String mail,Mail mailstructure) {
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setFrom(frommail);
		simpleMailMessage.setSubject(mailstructure.getSubject());
		simpleMailMessage.setText(mailstructure.getMessage());
		simpleMailMessage.setTo(mail);
		mailSender.send(simpleMailMessage);
		
	}
}
