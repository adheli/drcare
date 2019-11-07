package ie.ait.bteam.drcare.rest.service;


import ie.ait.bteam.drcare.data.model.User;
import ie.ait.bteam.drcare.data.service.UserService;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.translator.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientRestService {

    private UserService userService;
    private Translator<User, UserDTO> userTranslator;

    @Autowired
    public PatientRestService(UserService userService, Translator<User, UserDTO> userTranslator) {
        this.userService = userService;
        this.userTranslator = userTranslator;
    }

    public UserDTO createPatient(UserDTO patient, BindingResult result) {
        User createdPatient = userTranslator.translateTo(patient);
        createdPatient.setUserType(UserType.PATIENT.toString());
        createdPatient = userService.createUser(createdPatient, result);

        return userTranslator.translateFrom(createdPatient);
    }

    public List<UserDTO> listPatients() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userService.findByUserType(UserType.PATIENT.toString()).forEach(user -> userDTOS.add(userTranslator.translateFrom(user)));
        return userDTOS;
    }
}
