package ie.ait.bteam.drcare.rest.service;


import ie.ait.bteam.drcare.data.model.Patient;
import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.PatientService;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.PatientDTO;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientRestService {

    private PatientService patientService;
    private Translator<Patient, PatientDTO> patientTranslator;

    @Autowired
    public PatientRestService(PatientService patientService,@Qualifier("patientToPatientDTOTranslator") Translator<Patient, PatientDTO> patientTranslator) {
        this.patientService = patientService;
        this.patientTranslator = patientTranslator;
    }

    public PatientDTO createPatient(PatientDTO patient, BindingResult result) {
        Patient patientModel = patientTranslator.translateTo(patient);
        System.out.println(patientModel);
        patientModel = patientService.create(patientModel);

        return patientTranslator.translateFrom(patientModel);
    }

    public List<PatientDTO> listPatients() {
        List<PatientDTO> patientDTOs = new ArrayList<>();

        patientService.readAll().forEach(patient -> patientDTOs.add(patientTranslator.translateFrom(patient)));
        return patientDTOs;
    }

    public List<PatientDTO>  searchByName(String name){
        List<PatientDTO> patientDTOs = new ArrayList<>();

        patientService.findByName(name).forEach(patient -> patientDTOs.add(patientTranslator.translateFrom(patient)));
        return patientDTOs;
    }
}
