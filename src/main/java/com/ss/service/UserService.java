package com.ss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dto.LoginRequest;
import com.ss.dto.UserResponse;
import com.ss.entity.Product;
import com.ss.entity.User;
import com.ss.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User getUserByEmail(LoginRequest loginReq){
		String email = loginReq.getEmailid();
		String pwd = loginReq.getPwd();
		User user = userRepo.findByEmail(email, pwd);
		/*
		 * if (user == null) { throw new
		 * UsernameNotFoundException("User not found"); }
		 */
		return user;
	}

	public List<UserResponse> getAllUsers(){
		List<User> products = userRepo.findAll();
		return products.stream().map(this::mapToUserResponse).toList();
	}
	

	
	private UserResponse mapToUserResponse(User user) {
		int userid = user.getUserid();
		String f_name = user.getF_name();
		String l_name = user.getL_name();
		String emailid = user.getEmailid();
		long ph = user.getPh();
		int age = user.getAge();
		char gender = user.getGender();
		String role = user.getRole();
	
		
		UserResponse userResponse = new UserResponse(userid, emailid, f_name,
									l_name, ph, age, gender, role);
		return userResponse;
	}

	public List<User> listAll(String keyword) {
		if (keyword != null) {
		return userRepo.search(keyword);
		}else {
		return userRepo.findAll();}
	}

	
	

}
