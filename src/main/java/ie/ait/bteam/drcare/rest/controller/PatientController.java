package ie.ait.bteam.drcare.rest.controller;


import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.service.PatientRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientRestService patientRestService;

    @Autowired
    public PatientController(PatientRestService patientRestService){
        this.patientRestService = patientRestService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user, BindingResult result) {
        UserDTO createdPharmacist = patientRestService.createPatient(user, result);

        return new ResponseEntity<>(createdPharmacist, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(patientRestService.listPatients(), HttpStatus.OK);
    }

}
