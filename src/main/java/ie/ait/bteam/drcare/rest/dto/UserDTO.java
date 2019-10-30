package ie.ait.bteam.drcare.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserDTO implements Serializable {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private Boolean isAdmin;

	@Getter
	@Setter
	private MedicalStaffType userType;
}
