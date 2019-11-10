package ie.ait.bteam.drcare.rest.controller;


import ie.ait.bteam.drcare.rest.dto.UserDTO;
import ie.ait.bteam.drcare.rest.dto.UserType;
import ie.ait.bteam.drcare.rest.exceptions.EntityNotFound;
import ie.ait.bteam.drcare.rest.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ie.ait.bteam.drcare.rest.dto.UserType.PATIENT;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private UserRestService userRestService;

    @Autowired
    public PatientController(UserRestService userRestService){
        this.userRestService = userRestService;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user, BindingResult result) {
        UserDTO createdPatient = userRestService.createUser(user, result);

        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return new ResponseEntity<>(userRestService.listUsersByType(UserType.PATIENT.name()), HttpStatus.OK);
    }

    @GetMapping("/search/{username}")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> searchUser(@PathVariable String username) {
        try {
            List<UserDTO> searchedPatient = userRestService.searchUserByUsernameAndType(username, PATIENT.name());
            return new ResponseEntity<>(searchedPatient, HttpStatus.OK);
        } catch (EntityNotFound entityNotFound) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);   
        }
    }

}
