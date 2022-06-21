package net.atos.test.services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.atos.test.entities.User;
import net.atos.test.handler.UserException;
import net.atos.test.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	private String message;
	
	public User saveUser(User user) {
		Date getYearStDate=user.getBirthdate();
		SimpleDateFormat dtf =new SimpleDateFormat("yyyy"); 
		System.out.println("Année de naissance: "+dtf.format(getYearStDate));
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Année en cours: "+localDateTime.getYear());
		int age=(localDateTime.getYear()-Integer.parseInt(dtf.format(getYearStDate)));
		if(age<18) {
			System.out.println("Vous êtes mineur");
			message="Vous etes mineur";
		}else if (user.getCountry()!="France") {
			System.out.println("Vous n'etes pas resident francais");
			message="seul les residents francais peuvent créer un compte";
		}else {
			userRepository.save(user);
			message="Enregistrer avec succes";
		}
		return userRepository.save(user);
	}
	
	public User getUserDetails(int id) {
		User user=userRepository.findById(id).get();
		return user;
	}
}
