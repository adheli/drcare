package ie.ait.bteam.drcare.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PrescriptionDTO implements Serializable, Comparable<PrescriptionDTO> {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private String referenceId;

	@Getter
	@Setter
	private Date createdDate;

	@Getter
	@Setter
	private List<MedicineDTO> medicineDTOS;

	@Getter
	@Setter
	private PatientDTO patientDTO;

	@Getter
	@Setter
	private MedicalStaffDTO doctor;

	@Getter
	@Setter
	private MedicalStaffDTO pharmacist;

	@Getter
	@Setter
	private String notes;

	@Getter
	@Setter
	private PrescriptionStatus status;

	@Override
	public int compareTo(PrescriptionDTO o) {
		if (id.compareTo(o.id) == 0)
			return referenceId.compareTo(o.referenceId);
		else return id.compareTo(o.id);
	}
}
