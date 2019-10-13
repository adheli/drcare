package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class AddressDTO implements Serializable {

	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String street;

	@Getter
	@Setter
	private String additionalAddress;

	@Getter
	@Setter
	private String eirCode;

	@Getter
	@Setter
	private String town;

	@Getter
	@Setter
	private String county;

	@Getter
	@Setter
	private String country;
}
