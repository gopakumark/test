/**
 * 
 */
package example.spring.session.controller;


import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.spring.session.model.User;
import example.spring.session.service.UserService;

/**
 * @author Neev
 *
 */
@RestController
public class RestDemoController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/",produces = "application/json")
	public Map<String,String> helloUser(Principal principal) {
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("username", principal.getName());
		return result;
	}

	@RequestMapping("/logout")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@RequestMapping(value="/{name}",produces = "application/json")
	public Map<String,String> greetUser(@PathVariable(value="name")String name) {
		HashMap<String,String> result = new HashMap<String,String>();
		result.put("username", name);
		result.put("greeting", "Warm welcome to spring session");
		return result;
	}
	@RequestMapping(value="/user/{name}",produces="application/json")
	public User getUser(@PathVariable("name")String name){
		return userService.findByUserName(name);
	}
}
