package ie.ait.bteam.drcare.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class UserDTO implements Serializable {

	@Getter
	@Setter
	@ApiModelProperty(hidden = true)
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
