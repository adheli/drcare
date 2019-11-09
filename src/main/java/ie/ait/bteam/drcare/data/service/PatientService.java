package ie.ait.bteam.drcare.data.service;


import ie.ait.bteam.drcare.data.model.Patient;
import ie.ait.bteam.drcare.data.repository.PatientRepository;
import ie.ait.bteam.drcare.data.validator.UserValidator;
import ie.ait.bteam.drcare.rest.dto.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient create(Patient patient){
        patient.setUserType(UserType.PATIENT.name());
       return patientRepository.save(patient);
    }

    public Patient create(Patient patient, Errors errors){
        patient.setUserType(UserType.PATIENT.name());
        UserValidator userValidator = new UserValidator();
        userValidator.validate(patient, errors);
        return patientRepository.save(patient);
    }

    public List<Patient> readAll(){
        return  patientRepository.findAll();
    }

    public Patient update(Patient patient){
        return patientRepository.save(patient);
    }

    public void delete(Patient patient){
        patientRepository.delete(patient);
    }

    public List<Patient> findByName(String name) {
        return patientRepository.findByName(name);
    }
}
