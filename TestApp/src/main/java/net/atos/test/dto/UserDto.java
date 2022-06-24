package net.atos.test.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDto {

	private Integer user_id;
	private String name;
	private Date birthdate;
	private String country;
	private String phoneNumber;
	private String gender;
}
