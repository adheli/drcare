package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class UserDTO implements Serializable {


	private Long id;

	@NotBlank(message = "Name should not be blank")
	private String name;

	@NotBlank(message = "username should not be blank")
	private String username;

	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Email is required")
	private String email;

	private Boolean isAdmin = false;
}
