package ie.ait.bteam.drcare.rest.translator.impl;

import ie.ait.bteam.drcare.data.model.Allergy;
import ie.ait.bteam.drcare.data.model.Patient;
import ie.ait.bteam.drcare.data.model.Prescription;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.rest.dto.PatientDTO;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import ie.ait.bteam.drcare.util.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jaohar Oseni
 *
 * Class to map an Patient model to a PatientDTO model and vice-versa.
 */
@Component
@Qualifier("patientToPatientDTOTranslator")
public class PatientToPatientDTOTranslator implements Translator<Patient, PatientDTO> {

	@Override
	public PatientDTO translateFrom(Patient original) {
		PatientDTO patientDTO = new PatientDTO();
		BeanUtils.copyProperties(original, patientDTO);
		return patientDTO;
	}

	@Override
	public Patient translateTo(PatientDTO copy) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(copy, patient);

		List<Allergy> allergies = new ArrayList<>();
		List<Prescription> prescriptions = new ArrayList<>();

		BeanUtils.copyProperties(allergies, copy.getAllergies());
		BeanUtils.copyProperties(prescriptions, copy.getPrescriptions());

		patient.setAllergies(allergies);
		patient.setPrescriptions(prescriptions);




		return patient;
	}

}
