package net.atos.test.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@ToString
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name","phoneNumber"})})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull(message = "Birthdate is mandatory")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	@NotBlank(message = "Country is mandatory")
	private String country;
	//@Column(unique = true)
	private String phoneNumber;
	private String gender;
	
	public User(Integer user_id) {
		super();
		this.user_id = user_id;
	}

	
	
}
