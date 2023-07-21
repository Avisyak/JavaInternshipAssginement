package com.InternSathi.InternSathiAssginement.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.InternSathi.InternSathiAssginement.Utils.MailUtil;

@Controller
public class MailController {
	
	@Autowired
	private MailUtil mailutil;
	@GetMapping("/contact")
	public String getContact(HttpSession session) {
        
		return "Contact";
	}
	
	@PostMapping("/contact")
	public String postEmail(@RequestParam String name,@RequestParam String email,@RequestParam String subject,@RequestParam String message) {
	mailutil.sendEmail(name,email,subject,message);
	return "Contact";
		
	}
	
	
	
	

}
