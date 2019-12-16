package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DaoImpl.RegisterDaoImpl;
import com.pojos.User;

@Controller
public class RegisterController {
	
	RegisterDaoImpl daoimpl = new RegisterDaoImpl();
	
	@RequestMapping(value="/Registration Page")
	public String userRegistration(User us, Model m) throws Exception {
		System.out.println("Entered into saveUser");
		
		System.out.println(us.getId()+" "+us.getName());
		
		daoimpl.saveUser(us);
		m.addAttribute("uList",us.getName());
		return "Login";
		
	}

}
