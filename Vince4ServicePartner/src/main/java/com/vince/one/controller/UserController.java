package com.vince.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vince.one.model.Person;
import com.vince.one.service.UserService;

@Controller
@RequestMapping("/test")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody Person getPersonInJSON(@PathVariable String name) {

		User user =  userService.loadUserByUsername(name);
		Person person= new Person();
		person.setName(user.getUsername());
		return person;
	}
	
}
