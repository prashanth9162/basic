package com.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DaoImpl.LoginDaoImpl;

@Controller
public class LoginController {
	
	LoginDaoImpl daoimpl = new LoginDaoImpl();
	
	@RequestMapping(value="/loginUser")
	public String loginUser(@RequestParam("id") int id, @RequestParam("password") String password, Model m) {
		System.out.println("Login method Triggered");
		System.out.println(id+":"+password);
		
		List  list = daoimpl.getUserDetails(id, password);
		
		if (list.isEmpty()) {
			System.out.println("Invalid Credentials stop login page");
			m.addAttribute("message", "Invalid login Credentials please try valid one");
			return "Login";
			
		} else {
			System.out.println("login successfully forward to profile page");
			m.addAttribute("userList",list);
		return "Success";
		}
	}
}
