package net.atos.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.atos.test.entities.User;
import net.atos.test.services.UserService;

@RestController
@RequestMapping("/atostest/api")
public class AtosTestWebServices {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		try {
			User userResponse= userService.saveUser(user);
			return new ResponseEntity<>(userResponse,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value = "/getUserDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserDetails(@RequestParam(name = "user_id", defaultValue = "") int id) {
		
		try {
			User user= userService.getUserDetails(id);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
