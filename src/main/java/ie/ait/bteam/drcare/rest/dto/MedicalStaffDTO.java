package ie.ait.bteam.drcare.rest.dto;

import lombok.Getter;
import lombok.Setter;

public class MedicalStaffDTO extends UserDTO implements Comparable<MedicalStaffDTO> {

	@Getter
	@Setter
	private String licence;

	@Getter
	@Setter
	private UserType staffType;

	@Override
	public int compareTo(MedicalStaffDTO o) {
		if (o.getId().compareTo(this.getId()) == 0)
			if (o.licence.compareTo(this.licence) == 0)
				if (o.getName().compareTo(this.getName()) == 0)
					return o.staffType.compareTo(this.staffType);
				else return o.getName().compareTo(this.getName());
			else return o.licence.compareTo(this.licence);
		else return o.getId().compareTo(this.getId());
	}
}
