package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class MedicineDTO implements Serializable, Comparable<MedicineDTO> {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String referenceId;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String typeDosage;

	@Getter
	@Setter
	private Integer dosage;

	@Override
	public int compareTo(MedicineDTO o) {
		if (id.compareTo(o.id) == 0)
			return referenceId.compareTo(o.referenceId);
		else return id.compareTo(o.id);
	}
}
