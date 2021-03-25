package com.deloitte.Patyal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deloitte.Patyal.service.LoginService;

/**
 * This class will handle all the Http requests related to the login page of the
 * application. It handles one GET and one POST request.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */
@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService service;

	/**
	 * @param model It is the holder for model attributes and is primarily designed
	 *              for adding attributes to the model.
	 * @return 		returns the login.html page to the /login Http request from the
	 *         		browser.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {

		return "login";
	}

	/**
	 * @param model 	It is the holder for model attributes and is primarily designed
	 *              	for adding attributes to the model.
	 * @param name  	It is the attribute which will retrieve the user name from the login page.
	 * @param password  It is the attribute which will retrieve the password from the login page.
	 * @return 			returns the list-todos.html page 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValidUser = service.validateUser(name, password);

		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		model.put("name", name);
		model.put("password", password);

		return "welcome";
	}

}