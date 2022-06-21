package net.atos.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import net.atos.test.entities.User;
import net.atos.test.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public ResponseEntity<User> saveUser(@Validated User user) {
		try {
			User userResponse= userService.saveUser(user);
			return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.CREATED);
		}
	}
}
