package com.ss.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dto.LoginRequest;
import com.ss.dto.UserRequest;
import com.ss.dto.UserResponse;
import com.ss.entity.User;
import com.ss.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/home", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	//@ResponseStatus(HttpStatus.OK)
	public ModelAndView validateUser(LoginRequest loginReq, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user= userService.getUserByEmail(loginReq);
		String userRole = user.getRole();
		session.setAttribute("userRole", userRole);
		if (userRole != null) {
			modelAndView.setViewName("homepage");
		} else {
			modelAndView.setViewName("loginerror");
		}
		return modelAndView;
	}
	
	@GetMapping(value = "/listusers", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView listUsers(@ModelAttribute("users")UserRequest userRequest, BindingResult result, ModelMap model) {	
		ModelAndView modelAndView = new ModelAndView();
		List<UserResponse> listOfUsers = userService.getAllUsers();
		model.addAttribute("list", listOfUsers);
		modelAndView.setViewName("listusers");
		return modelAndView;
	}
	
	@GetMapping("/listusers")
    public ModelAndView filterUsers(Model model, @Param("keyword") String keyword) {
        List<User> filterUsers = userService.listAll(keyword);
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("list", filterUsers);
        model.addAttribute("keyword", keyword);
        modelAndView.setViewName("listusers");
        return modelAndView;
    }
}
