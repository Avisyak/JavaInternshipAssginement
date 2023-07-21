package com.InternSathi.InternSathiAssginement.Controller;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.InternSathi.InternSathiAssginement.Model.User;
import com.InternSathi.InternSathiAssginement.Repository.UserRepository;
import com.InternSathi.InternSathiAssginement.Service.UserService;
import com.InternSathi.InternSathiAssginement.Utils.VerifyRecaptcha;

@Controller
public class UserController {
     @Autowired
	 private UserRepository userRepo;
	 
	@Autowired
	private UserService userserv;
	
	@GetMapping("/")
	public String getHome() {
		return "HomePage";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "UserLogin";
	}
	@GetMapping("/signup")
	public String getSignup() {
		return "UserSignup";
	}
    @PostMapping("/signup")
	public String getUserSignup(@ModelAttribute User user) {
		userserv.userSignup(user);
		return "UserSignup";
	}
    @PostMapping("/login")
    public String getUserLogin(@ModelAttribute User user,Model model,HttpSession session,HttpServletRequest request,@RequestParam String password) throws IOException {
    	String recaptchaCode = request.getParameter("g-recaptcha-response");
 //    	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
//    	Optional<User> opUser = userRepo.findById(user.getId());
    	if(VerifyRecaptcha.verify(recaptchaCode)) {
    		User usr = userserv.userLogin(user.getUsername(), user.getPassword());
//    		User dbUser = opUser.get();
    		if(usr!=null) {
    			//if(bcrypt.matches(user.getPassword(),password)) {
    				session.setAttribute("activeuser", usr);
        			session.setMaxInactiveInterval(20000);
        			return "HomePage";
    			
    			
    		}
    		model.addAttribute("error","User not found");
    		return "UserLogin";
    	}
    	model.addAttribute("error","You are Robot");
    	return "UserLogin";
    }
    @GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "UserLogin";
		
	}
    @GetMapping("/edituser")
	public String editProfile(Model model,HttpSession session) {
		User u = (User) session.getAttribute("activeuser");
		model.addAttribute("usermodel",u);
		return "EditProfile";
	}
	
    @PostMapping("/updateuser")
	public String updateprofile(@ModelAttribute User user,Model model) {
		
		userserv.userSignup(user);
//		model.addAttribute("updatemsg","your details  updated");
		return "redirect:/edituser";
		
	}

	
}
