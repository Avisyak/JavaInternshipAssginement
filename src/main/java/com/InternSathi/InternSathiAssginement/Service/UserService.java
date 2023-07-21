package com.InternSathi.InternSathiAssginement.Service;

import java.util.List;

import com.InternSathi.InternSathiAssginement.Model.User;

public interface UserService {
	void userSignup(User user);
	User userLogin(String un,String psw);
	User getUserById(int id);
	List<User> getAllUser();
//	boolean LoginUser(String username,String unencryptedpassword);

}
