package ie.ait.bteam.drcare.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class AllergyDTO implements Serializable {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String mainSubstance;

	@Getter
	@Setter
	private String description;
}
