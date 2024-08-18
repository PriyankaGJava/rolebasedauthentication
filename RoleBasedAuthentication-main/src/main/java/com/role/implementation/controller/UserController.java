package com.role.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.role.implementation.model.User;
import com.role.implementation.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		// create model attribute to bind form data
		User user = new User();
		model.addAttribute("user", user);
		return "newUser";
	}
	
	@PostMapping("/saveUser")
	public String saveEmployee(User user) {
		// save employee to database
		userService.saveUser(user);
		return "redirect:/adminScreen";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		// get employee from the service
		User user = userService.getUserById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.userService.deleteUserById(id);
		return "redirect:/adminScreen";
	}
	
}
