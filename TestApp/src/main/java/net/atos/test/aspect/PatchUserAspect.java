package net.atos.test.aspect;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.atos.test.entities.User;


public class PatchUserAspect {

	@Pointcut("execution(* net.atos.test.services.UserService.saveUser(..)")
	public void patchUserPointCut() {
	}

	@Around("patchUserPointCut() && args(user)")
	public Object patchUserSave(User user, ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint)
			throws Throwable {

		// UserService userService = (UserService) joinPoint.getTarget();
		Date getYearStDate = user.getBirthdate();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy");
		System.out.println("Année de naissance: " + dtf.format(getYearStDate));
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Année en cours: " + localDateTime.getYear());

		int age = (localDateTime.getYear() - Integer.parseInt(dtf.format(getYearStDate)));

		if (age < 18) {
			throw new RuntimeException("Vous êtes mineur");
		} else if (user.getCountry() != "France") {

			throw new RuntimeException(
					"Vous n'etes pas resident francais, seul les residents francais peuvent créer un compte ");
		}
		return proceedingJoinPoint.proceed();
	}

}
