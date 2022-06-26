package net.atos.test.services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.atos.test.dto.UserDto;
import net.atos.test.entities.User;
import net.atos.test.handler.UserNotFoundException;
import net.atos.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	ModelMapper modelMapper;
	// private String message;

	/**
	 * @param user
	 * @return Methode permettant d'enregistrer un Utilisateur
	 */
	public User saveUser(User user) {

		if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {

			throw new RuntimeException("Phone Number is already exists");
		}

		if (userRepository.existsByPhoneNumber(user.getName())) {
			throw new RuntimeException("UserName is already exists");
		}

		Date getYearStDate = user.getBirthdate();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy");
		System.out.println("Année de naissance: " + dtf.format(getYearStDate));
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Année en cours: " + localDateTime.getYear());

		int age = (localDateTime.getYear() - Integer.parseInt(dtf.format(getYearStDate)));

		if (age < 18) {
			throw new RuntimeException("Vous êtes mineur");
		}
		if (!user.getCountry().equals("france")) {
			throw new RuntimeException(
					"Vous n'etes pas resident francais, seul les residents francais peuvent créer un compte ");
		}
		return userRepository.save(user);
	}

	/**
	 * @param id
	 * @return Methode permettant de recuperer les informations de l'utilisateur
	 */
	public User getUserDetails(int id) {
		Optional<User> result = userRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new UserNotFoundException(String.format("User %d not found", id));
		}

		// User user=userRepository.findById(id).orElseThrow(() -> new
		// UserNotFoundException(String.format("User %d not found", id)));
		// return user;
	}

	/**
	 * @param user
	 * @return Methode permettant de convertir User en Dto
	 */
	public UserDto convertUserToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	/**
	 * @param userDto
	 * @return Methode permettant de convertir Dto en User
	 */
	public User convertDtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
}
