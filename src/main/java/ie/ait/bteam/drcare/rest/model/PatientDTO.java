package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PatientDTO extends UserDTO implements Comparable<PatientDTO> {

	@Getter
	@Setter
	private String emergencyId;

	@Getter
	@Setter
	private AddressDTO address;

	@Getter
	@Setter
	private List<AllergyDTO> allergies;

	@Override
	public int compareTo(PatientDTO o) {
		if (o.getId().compareTo(this.getId()) == 0)
			if (o.emergencyId.compareTo(this.emergencyId) == 0)
				return o.getName().compareTo(this.getName());
			else return o.emergencyId.compareTo(this.emergencyId);
		else return o.getId().compareTo(this.getId());
	}
}
