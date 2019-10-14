package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserDTO implements Serializable {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@NotBlank(message = "Name should not be blank")
	private String name;

	@Getter
	@Setter
	@NotBlank(message = "username should not be blank")
	private String username;

	@Getter
	@Setter
	@NotBlank(message = "Password is required")
	private String password;

	@Getter
	@Setter
	@NotBlank(message = "Email is required")
	private String email;

	@Getter
	@Setter
	private Boolean isAdmin;
}
