package net.atos.test.rest;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.atos.test.dto.UserDto;
import net.atos.test.entities.User;
import net.atos.test.handler.UserNotFoundException;
import net.atos.test.repository.UserRepository;
import net.atos.test.services.UserService;

@RestController
@RequestMapping("/atostest/api")
public class AtosTestWebServices {

	@Autowired
	private UserService userService;
	@Autowired
	ModelMapper modelMapper;

	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@Valid @RequestBody UserDto userDto) {
		try {

			User user = userService.convertDtoToUser(userDto);
			User userCreated = userService.saveUser(user);

			return new ResponseEntity<>(userService.convertUserToDto(userCreated), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(value = "/getUserDetails/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUserDetails(@PathVariable int id) {
		UserDto userDto = userService.convertUserToDto(userService.getUserDetails(id));
		return ResponseEntity.ok().body(userDto);
	}
}
