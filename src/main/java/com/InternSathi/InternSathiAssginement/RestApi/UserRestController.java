package com.InternSathi.InternSathiAssginement.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.InternSathi.InternSathiAssginement.Model.User;
import com.InternSathi.InternSathiAssginement.Service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserRestController {
  @Autowired
  private UserService service;
  
  @GetMapping("/user/api/list")
  public List<User> getAllUser(){
  	
  	return service.getAllUser();
  }
  @PostMapping("/user/api/register")
  public String addUser(@RequestBody User user) {
  	
  	service.userSignup(user);
  	return "Signupsuccess";
  }
  @GetMapping("/user/api/{id}")
	public User getOneUser(@PathVariable int id) {
		return service.getUserById(id);
	}
  
  @PostMapping("/user/api/login")
  public String UserLogin(@RequestBody User user) {
  	
  	service.userLogin(user.getUsername(), user.getPassword());
  	return "Loginsuccess";
  }
  
}
