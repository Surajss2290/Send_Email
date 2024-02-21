package com.example.count.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.count.model.Mail;
import com.example.count.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired 
	private MailService mailService;
	
	@PostMapping("/send/{mail}")
	public String sendMail(@PathVariable String mail,@RequestBody Mail mailstructure) {
		
		mailService.sendMail(mail, mailstructure);
		return "Successfully send the mail";
	}

}
