package com.InternSathi.InternSathiAssginement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.InternSathi.InternSathiAssginement.Model.User;
import com.InternSathi.InternSathiAssginement.Repository.UserRepository;
import com.InternSathi.InternSathiAssginement.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignup(User user) {
		
		  BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		  String encryptedPsw = bcrypt.encode(user.getPassword());
		  user.setPassword(encryptedPsw);
		 
		  userRepo.save(user);
		
	}

	@Override
	public User userLogin(String un, String psw) {
		
		return userRepo.findByUsernameAndPassword(un,psw);
	}

	@Override
	public User getUserById(int id) {
		
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

}
