package com.ojas.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.ojas.entity.Utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.entity.User;

import com.ojas.service.UserServiceImpl;


@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService;

//	@GetMapping("/")
//	public String register(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "register";
//
//	}
//
//	@PostMapping("/registerUser")
//	public String registerUser(@ModelAttribute("user") User user,HttpServletRequest request) {
//		String result = "error";
//		System.out.println(user);
//		if (user.getPassword().equals(user.getCpassword())) {
//
//			try {
//				userService.registerUser(user);
//			//String sitURL=Utility.getSiteURL(request);
////			userService.sendVerificationEmail(user,sitURL);
//				result = "home";
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				result = "error";
//			}
//		}
//		return result;
//	}


	@GetMapping("/all")
	private List<User> getAllUser() {
		return userService.getAllUsers();

	}

	@GetMapping("/user/{id}")
	private Optional<User> getUserId(@PathVariable("id") int id) {
		System.out.println(id);
		return userService.getUserId(id);

	}

	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable("id") int id) {
		userService.delete(id);
	}

	@PostMapping("/saveUser")
	private User saveUser(@RequestBody User user) {
		User result=user;
if(user.getPassword().equals(user.getCpassword())) {
			
			try {
				
				result= userService.saveOrUpdate(user);
				System.out.println("Registation succesfull");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				user= null;
			}
		}
else {
	System.out.println("please enter currect password");
}
		return user;
		
}
//================================================
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
		
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		User oauthUser=userService.login(user.getUsername(), user.getPassword());
		System.out.println(oauthUser);
		if(Objects.nonNull(oauthUser)) {
			return "redirect:/welcome";
		}else {
			return "redirect:/login";
		}
		
		
	}
	@RequestMapping(value= {"/logout"},method=RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse responce) {
		return "redirect:/login";
		
	}
	@GetMapping("/welcome")
	public String welcome() {
		return "index";
		
	}
	
	
}
